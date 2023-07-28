package co.gov.ssoc.gedess.sgd.cfg.audit;

import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.event.spi.PostLoadEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.event.spi.PreDeleteEvent;
import org.hibernate.event.spi.PreDeleteEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.ssoc.gedess.sgd.cfg.ApplicationContextProvider;
import co.gov.ssoc.gedess.sgd.cfg.security.service.AuthService;

//@Component
public class HibernateAuditListener implements PostLoadEventListener, PostUpdateEventListener, PostInsertEventListener,
		PreDeleteEventListener, PostDeleteEventListener, PersistEventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger("audit-events");

//	@Autowired
	AuthService authService;

//	@Autowired
	private static KafkaTemplate<String, String> kafkaTemplate;

//	@Autowired
	private static ObjectMapper objMapper;

//    @Autowired
	private ApplicationContext applicationContext;

//	@Autowired
//	public void init(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objMapper) {
//		this.kafkaTemplate = kafkaTemplate;
//		this.objMapper = objMapper;
//	}

//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		this.kafkaTemplate = ApplicationContextProvider.getApplicationContext().getBean(KafkaTemplate.class);
//		this.objMapper = ApplicationContextProvider.getApplicationContext().getBean(ObjectMapper.class);
//	}

//	public HibernateAuditListener(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objMapper) {
//		this.kafkaTemplate = kafkaTemplate;
//		this.objMapper = objMapper;
//
//	}

//	public HibernateAuditListener() {
//		this.kafkaTemplate = ApplicationContextProvider.getApplicationContext().getBean(KafkaTemplate.class);
//		this.objMapper = ApplicationContextProvider.getApplicationContext().getBean(ObjectMapper.class);
//	}

	public void sendMessage(Object message) {
		this.authService = ApplicationContextProvider.getApplicationContext().getBean(AuthService.class);
		this.kafkaTemplate = ApplicationContextProvider.getApplicationContext().getBean(KafkaTemplate.class);
		this.objMapper = ApplicationContextProvider.getApplicationContext().getBean(ObjectMapper.class);
		try {
			kafkaTemplate.send("auditoria_log", objMapper.writeValueAsString(message));
		} catch (Exception e) {
			LOGGER.error("auditoria_log kafka message", e);
		}
	}

	public void sendMessage(String message) {
		kafkaTemplate.send("auditoria_log", message);
	}

	@Override
	public void onPostLoad(PostLoadEvent event) {
		LOGGER.info("Key = 'postload' value = '{}'", event.getEntity());
	}

//	@PostLoad
//	public void postLoad(Object entity) {
//		LOGGER.info("Key = 'postload' value = '{}'", entity);
//		sendMessage(entity);
//	}

	@Override
	public boolean requiresPostCommitHanding(EntityPersister persister) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		LOGGER.info("Key = '{}' value = '{}'", event.getClass(), event.getEntity());
		sendMessage(event.getEntity());
	}

	@Override
	public boolean onPreDelete(PreDeleteEvent event) {
		LOGGER.info("Key = '{}' value = '{}'", event.getClass(), event.getEntity());
		sendMessage(event.getEntity());
		return true;
	}

	@Override
	public void onPostInsert(PostInsertEvent event) {
		LOGGER.info("Key = '{}' value = '{}'", event.getClass(), event.getEntity());
		sendMessage(event.getEntity());

	}

	@Override
	public void onPostDelete(PostDeleteEvent event) {
		LOGGER.info("Key = '{}' value = '{}'", event.getClass(), event.getEntity());
		sendMessage(event.getEntity());
	}

	@Override
	public void onPersist(PersistEvent event) throws HibernateException {
		LOGGER.info("Key = '{}' value = '{}'", event.getClass(), event.getObject());
		sendMessage(event.getObject());
	}

	@Override
	public void onPersist(PersistEvent event, Map createdAlready) throws HibernateException {
		LOGGER.info("Key = '{}' value = '{}'", event.getClass(), event.getObject());
		sendMessage(event.getObject());
	}

}
