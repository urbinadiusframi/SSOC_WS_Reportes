package co.gov.ssoc.gedess.sgd.cfg;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
public class SSOCCfgMain {

//	@Bean
//	io.debezium.config.Configuration customerConnector(Environment env) {
//		return io.debezium.config.Configuration.create().with("name", "ssoc_gedess_connector")
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
//				.with("database.history.file.filename", "/tmp/dbhistory.dat").with("database.encrypt", false).build();
//	}

}
