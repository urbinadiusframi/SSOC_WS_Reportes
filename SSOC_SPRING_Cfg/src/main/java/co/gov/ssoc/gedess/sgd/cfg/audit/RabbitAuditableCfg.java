package co.gov.ssoc.gedess.sgd.cfg.audit;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class RabbitAuditableCfg {

	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;

	@Value(value = "${ssoc.audit.queue}")
	private String queueAuditoria;

	@Bean(name = "asyncTaskExecutorRabbitAuditable")
	ThreadPoolTaskExecutor asyncTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(50);
		executor.setThreadNamePrefix("RabbitAuditableAsyncTask-");
		executor.initialize();
		return executor;
	}

	@Bean
	Queue queueAuditoria() {
		return new Queue(queueAuditoria);
	}

}
