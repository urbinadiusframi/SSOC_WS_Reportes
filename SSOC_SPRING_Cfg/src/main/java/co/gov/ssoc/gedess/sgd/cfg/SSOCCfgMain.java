package co.gov.ssoc.gedess.sgd.cfg;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import co.gov.ssoc.gedess.sgd.cfg.audit.HibernateAuditListener;

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

	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;

	@Bean
	ProducerFactory<String, String> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

//	@Bean
//	public HibernateAuditListener hibernateAuditListener(KafkaTemplate<String, String> kafkaTemplate,
//			ObjectMapper objMapper) {
//		return new HibernateAuditListener(kafkaTemplate, objMapper);
//	}
//	@Bean
//    public HibernateAuditListener customPostLoadListener() {
//        return new HibernateAuditListener();
//    }
}
