package co.gov.ssoc.gedess.sgd.cfg.audit;

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
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
//@Profile("!prod")
//@org.springframework.data.envers.repository.config.EnableEnversRepositories
//@EnableJpaAuditing
public class PersistenceENVERSConfig {
	private static final String PERSISTENCE_JNDI_CONFIG = "PersistenceENVERSConfig -->{}<--";

	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceENVERSConfig.class);

	@Value("${spring.profiles.active:}")
	private String activeProfile;

	@Value("#{systemProperties['dacartec.jdbc.datasource.jdni.envers']}")
	private String systemPropertiesDacartectJdbcDatasourceJdni;

	@Autowired
	private Environment env;

//	@Bean(name = "enversDataSource")
//	DataSource auditDataSource() throws NamingException {
//		LOGGER.info(PERSISTENCE_JNDI_CONFIG, activeProfile);
//		if (activeProfile.equals("prod")) {
//			LOGGER.info(PERSISTENCE_JNDI_CONFIG, systemPropertiesDacartectJdbcDatasourceJdni);
//			JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
//			return dataSourceLookup.getDataSource(systemPropertiesDacartectJdbcDatasourceJdni);
//		}
//		LOGGER.info(PERSISTENCE_JNDI_CONFIG, env.getProperty("jdbc.envers.datasource.url"));
//		LOGGER.info("hibernate.envers.default_catalog -->{}<--",
//				env.getProperty("jdbc.envers.org.hibernate.envers.default_catalog"));
//		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
////		dataSource.setDriverClassName(env.getProperty("jdbc.envers.datasource.driverClassName") != null
////				? env.getProperty("jdbc.envers.datasource.driverClassName")
////				: "");
//		dataSource.setConnectionProperties(auditHibernateProperties());
//		dataSource.setUrl(env.getProperty("jdbc.envers.datasource.url"));
//		dataSource.setUsername(env.getProperty("jdbc.envers.datasource.username"));
//		dataSource.setPassword(env.getProperty("jdbc.envers.datasource.password"));
//		return dataSource;
//	}

//	@Bean(name = "enversEntityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean auditEntityManagerFactory(
//			@Qualifier("enversDataSource") DataSource auditDataSource) {
//		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//		em.setDataSource(auditDataSource);
//		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//		em.setPackagesToScan("co.gov.ssoc.gedess.sgd.**.entity.audit");
//		em.setJpaProperties(auditHibernateProperties());
//		return em;
//	}

//	private Properties auditHibernateProperties() {
//		Properties properties = new Properties();
////		properties.put("hibernate.id.new_generator_mappings", env.getProperty("jdbc.jpa.hibernate.use-new-id-generator-mappings")); activar en dev y prod
//		properties.put("hibernate.show_sql", env.getProperty("jdbc.jpa.show-sql"));
//		properties.put("hibernate.format_sql", env.getProperty("jdbc.jpa.format-sql"));
//		properties.put("hibernate.generate_statistics",
//				env.getProperty("jdbc.jpa.properties.hibernate.generate_statistics"));
//		properties.setProperty("hibernate.jdbc.time_zone",
//				env.getProperty("jdbc.jpa.properties.hibernate.jdbc.time_zone"));
//		properties.setProperty("hibernate.dialect", env.getProperty("jdbc.jpa.hibernate.dialect"));
//		properties.setProperty("hibernate.connection.url", env.getProperty("jdbc.envers.datasource.url"));
//		properties.setProperty("hibernate.connection.username", env.getProperty("jdbc.envers.datasource.username"));
//		properties.setProperty("hibernate.connection.password", env.getProperty("jdbc.envers.datasource.password"));
//		if (activeProfile.compareToIgnoreCase("test") == 0) {
//			LOGGER.info(PERSISTENCE_JNDI_CONFIG, activeProfile);
//			LOGGER.info("ddl-auto -->{}<--", env.getProperty("jdbc.jpa.hibernate.ddl-auto"));
//			properties.put("hibernate.hbm2ddl.auto",
//					env.getProperty("jdbc.envers.jpa.hibernate.ddl-auto") != null
//							? env.getProperty("jdbc.envers.jpa.hibernate.ddl-auto")
//							: "validate");
//			properties.put("org.hibernate.envers.store_data_at_delete",
//					env.getProperty("jdbc.hibernate.envers.store_data_at_delete") != null
//							? env.getProperty("jdbc.hibernate.envers.store_data_at_delete")
//							: "true");
//			properties.put("org.hibernate.envers.default_schema",
//					env.getProperty("jdbc.envers.org.hibernate.envers.default_schema") != null
//							? env.getProperty("jdbc.envers.org.hibernate.envers.default_schema")
//							: "Administracion");
////			properties.put("org.hibernate.envers.default_catalog",
////					env.getProperty("jdbc.envers.org.hibernate.envers.default_catalog") != null
////							? env.getProperty("jdbc.envers.org.hibernate.envers.default_catalog")
////							: "SDGTEST");
//			properties.setProperty("org.hibernate.envers.audit_table_suffix",
//					env.getProperty("jdbc.envers.hibernate.envers.audit_table_suffix") != null
//							? env.getProperty("jdbc.envers.hibernate.envers.audit_table_suffix")
//							: "_AUDIT_LOG");
//		}
//		return properties;
//	}

//	@Bean
//	public PlatformTransactionManager enversTransactionManager(
//			@Qualifier("enversEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//		return new JpaTransactionManager(entityManagerFactory);
//	}
	


//	@Bean
//	io.debezium.config.Configuration customerConnector(Environment env) {
//		return io.debezium.config.Configuration.create().with("name", "customer-mysql-connector")
//				.with("connector.class", "io.debezium.connector.sqlserver.SqlServerConnector")
//				.with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
//				.with("offset.storage.file.filename", "/tmp/offsets.dat").with("offset.flush.interval.ms", "60000")
//				.with("database.hostname", env.getProperty("jdbc.envers.datasource.host"))
//				.with("database.port", env.getProperty("jdbc.envers.datasource.port"))
//				.with("database.user", env.getProperty("jdbc.envers.datasource.username"))
//				.with("database.password", env.getProperty("jdbc.envers.datasource.password"))
//				.with("database.dbname", env.getProperty("jdbc.envers.org.hibernate.envers.default_catalog"))
//				.with("database.include.list", env.getProperty("jdbc.envers.org.hibernate.envers.default_catalog"))
//				.with("include.schema.changes", "false").with("database.server.id", "10181")
//				.with("database.server.name", "customer-mysql-db-server")
//				.with("database.history", "io.debezium.relational.history.FileDatabaseHistory")
//				.with("database.history.file.filename", "/tmp/dbhistory.dat").with("database.encrypt", false)
//				.build();
//	}

}