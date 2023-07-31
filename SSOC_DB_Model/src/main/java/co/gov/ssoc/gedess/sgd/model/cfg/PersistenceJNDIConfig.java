package co.gov.ssoc.gedess.sgd.model.cfg;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "co.gov.ssoc.gedess.sgd.**.repository"
//, repositoryFactoryBeanClass = org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean.class // activar
)
public class PersistenceJNDIConfig {
	private static final String PERSISTENCE_JNDI_CONFIG = "PersistenceJNDIConfig -->{}<--";

	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceJNDIConfig.class);

	@Autowired
	private Environment env;

	@Value("${spring.profiles.active:}")
	private String activeProfile;

	@Value("#{systemProperties['dacartec.jdbc.datasource.jdni']}")
	private String systemPropertiesDacartectJdbcDatasourceJdni;

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource auditDataSource) {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(auditDataSource);
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setPackagesToScan("co.gov.ssoc.gedess.sgd.**.entity");
		em.setJpaProperties(hibernateProperties());
		return em;
	}

	@Primary
	@Bean(name = "dataSource")
	public DataSource primaryDataSource() throws NamingException {
		LOGGER.info(PERSISTENCE_JNDI_CONFIG, activeProfile);
		if (activeProfile.equals("prod")) {
			LOGGER.info(PERSISTENCE_JNDI_CONFIG, systemPropertiesDacartectJdbcDatasourceJdni);
			JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
			return dataSourceLookup.getDataSource(systemPropertiesDacartectJdbcDatasourceJdni);
		}
		LOGGER.info(PERSISTENCE_JNDI_CONFIG, env.getProperty("jdbc.datasource.url"));
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.datasource.driverClassName") != null
				? env.getProperty("jdbc.datasource.driverClassName")
				: "");
		dataSource.setUrl(env.getProperty("jdbc.datasource.url"));
		dataSource.setUsername(env.getProperty("jdbc.datasource.username"));
		dataSource.setPassword(env.getProperty("jdbc.datasource.password"));
		return dataSource;
	}

//	@Autowired
//	HibernateAuditListener hibernateAuditListener;

	private Properties hibernateProperties() {
		Properties properties = new Properties();

//		properties.put("hibernate.id.new_generator_mappings", env.getProperty("jdbc.jpa.hibernate.use-new-id-generator-mappings")); activar en dev y prod
		properties.put("hibernate.show_sql", false);
		properties.put("hibernate.format_sql", false);
		properties.put("hibernate.generate_statistics", false);
		properties.put("hibernate.ejb.event.post-insert", "co.gov.ssoc.gedess.sgd.cfg.audit.HibernateAuditListener");
		properties.put("hibernate.ejb.event.post-delete", "co.gov.ssoc.gedess.sgd.cfg.audit.HibernateAuditListener");
		properties.put("hibernate.ejb.event.post-update", "co.gov.ssoc.gedess.sgd.cfg.audit.HibernateAuditListener");
//		properties.put("hibernate.ejb.event.post-load", "co.gov.ssoc.gedess.sgd.cfg.audit.HibernateAuditListener");
		properties.setProperty("hibernate.jdbc.time_zone",
				env.getProperty("jdbc.jpa.properties.hibernate.jdbc.time_zone"));
		properties.setProperty("hibernate.dialect", env.getProperty("jdbc.jpa.hibernate.dialect"));
		if (activeProfile.compareToIgnoreCase("test") == 0) {
			LOGGER.info(PERSISTENCE_JNDI_CONFIG, activeProfile);
//			LOGGER.info("ddl-auto -->{}<--", env.getProperty("jdbc.jpa.hibernate.ddl-auto"));
			properties.put("hibernate.hbm2ddl.auto",
					env.getProperty("jdbc.jpa.hibernate.ddl-auto") != null
							? env.getProperty("jdbc.jpa.hibernate.ddl-auto")
							: "validate");
//			properties.put("org.hibernate.envers.store_data_at_delete",
//					env.getProperty("jdbc.hibernate.envers.store_data_at_delete") != null
//							? env.getProperty("jdbc.hibernate.envers.store_data_at_delete")
//							: "true");
//			properties.put("org.hibernate.envers.default_schema",
//					env.getProperty("jdbc.envers.org.hibernate.envers.default_schema") != null
//							? env.getProperty("jdbc.envers.org.hibernate.envers.default_schema")
//							: "Administracion");
//			properties.put("org.hibernate.envers.default_catalog",
//					env.getProperty("jdbc.envers.org.hibernate.envers.default_catalog") != null
//							? env.getProperty("jdbc.envers.org.hibernate.envers.default_catalog")
//							: "SDGTEST");
//			properties.setProperty("org.hibernate.envers.audit_table_suffix", "_AUDIT_LOG");
		}
		return properties;
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
