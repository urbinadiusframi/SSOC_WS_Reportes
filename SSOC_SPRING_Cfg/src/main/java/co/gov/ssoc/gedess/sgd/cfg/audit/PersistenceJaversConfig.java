package co.gov.ssoc.gedess.sgd.cfg.audit;

import javax.naming.NamingException;
import javax.sql.DataSource;

//import org.javers.core.Javers;
//import org.javers.hibernate.integration.HibernateUnproxyObjectAccessHook;
//import org.javers.repository.sql.ConnectionProvider;
//import org.javers.repository.sql.DialectName;
//import org.javers.repository.sql.JaversSqlRepository;
//import org.javers.repository.sql.SqlRepositoryBuilder;
//import org.javers.spring.jpa.JpaHibernateConnectionProvider;
//import org.javers.spring.jpa.TransactionalJpaJaversBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
public class PersistenceJaversConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceJaversConfig.class);

//	@Bean(name = "enversDataSource")
//	DataSource auditDataSource(Environment env) throws NamingException {
//		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//		dataSource.setUrl(env.getProperty("jdbc.envers.datasource.url"));
//		dataSource.setUsername(env.getProperty("jdbc.envers.datasource.username"));
//		dataSource.setPassword(env.getProperty("jdbc.envers.datasource.password"));
//		return dataSource;
//	}
//
//	@Bean
//	public Javers javers(PlatformTransactionManager txManager) {
//		return TransactionalJpaJaversBuilder.javers().withTxManager(txManager)
//				.withObjectAccessHook(new HibernateUnproxyObjectAccessHook())
//				.registerJaversRepository(SqlRepositoryBuilder.sqlRepository()
//						.withConnectionProvider(jpaConnectionProvider()).withDialect(DialectName.MSSQL).build())
//				.build();
//	}
//
//	@Bean
//	public ConnectionProvider jpaConnectionProvider() {
//		return new JpaHibernateConnectionProvider();
//	}
}