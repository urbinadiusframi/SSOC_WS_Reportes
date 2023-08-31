package co.gov.ssoc.gedess.sgd.cfg.audit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class KafkaAuditable {

	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;

	@Value(value = "${spring.kafka.topic-auditable}")
	private String topicAuditable;

	@Bean(name = "asyncTaskExecutorKafkaAuditable")
	public ThreadPoolTaskExecutor asyncTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(50);
		executor.setThreadNamePrefix("KafkaAuditableAsyncTask-");
		executor.initialize();
		return executor;
	}

//	@Bean
//	ProducerFactory<String, String> producerFactory() {
//		Map<String, Object> configProps = new HashMap<>();
//		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		return new DefaultKafkaProducerFactory<>(configProps);
//	}
//
//	@Bean
//	KafkaTemplate<String, String> kafkaTemplate() {
//		return new KafkaTemplate<>(producerFactory());
//	}
//
//	@Bean
//	KafkaAdmin kafkaAdmin() {
//		Map<String, Object> configs = new HashMap<>();
//		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//		return new KafkaAdmin(configs);
//	}
//
//	@Bean
//	NewTopic topic1() {
//		return new NewTopic(topicAuditable, 1, (short) 1);
//	}

}
