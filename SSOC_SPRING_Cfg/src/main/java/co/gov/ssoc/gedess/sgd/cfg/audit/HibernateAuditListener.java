package co.gov.ssoc.gedess.sgd.cfg.audit;

import java.lang.reflect.Field;
import java.util.Date;
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
import org.slf4j.MDC;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.ssoc.gedess.sgd.cfg.ApplicationContextProvider;
import co.gov.ssoc.gedess.sgd.cfg.Constantes;
import co.gov.ssoc.gedess.sgd.cfg.audit.dto.AuditoriaDTO;
import co.gov.ssoc.gedess.sgd.cfg.audit.dto.EAuditType;
import co.gov.ssoc.gedess.sgd.cfg.security.AuthTokenFilter;

public class HibernateAuditListener implements PostLoadEventListener, PostUpdateEventListener, PostInsertEventListener,
		PreDeleteEventListener, PostDeleteEventListener, PersistEventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger("audit-events");

	public void sendMessage(Object message, EAuditType type) {
		try {
			String comp = MDC.get(AuthTokenFilter.AUDIT_COMPONENT);
			String usuario = MDC.get(AuthTokenFilter.AUDIT_USER);
			String usuarioid = MDC.get(AuthTokenFilter.AUDIT_USER_ID);
			String ipAddress = MDC.get(AuthTokenFilter.AUDIT_ORIGIN_IP_ADDRESS);

			Class<?> clazz = message.getClass();
			Field[] fields = clazz.getDeclaredFields();
			String identificador = null;
			for (Field field : fields) {
				if (field.isAnnotationPresent(org.springframework.data.annotation.Id.class)
						|| field.isAnnotationPresent(javax.persistence.Id.class)) {
					field.setAccessible(true);
					Object idValue = field.get(message);
					identificador = idValue.toString();
					break;
				}
			}

			ApplicationContextProvider.getApplicationContext().getBean(AuditRevisionListener.class)
					.newRevision(AuditoriaDTO.builder().componente(comp).usuario(usuario).usuarioId(toLong(usuarioid))
							.maquina(ipAddress).entidad(clazz.getCanonicalName())
							.contenido(ApplicationContextProvider.getApplicationContext().getBean(ObjectMapper.class)
									.writeValueAsString(message))
							.identificador(identificador).tipo(type).fecha(new Date()).build());
		} catch (Exception e) {
			LOGGER.error("auditoria_log kafka message", e);
		}
	}

	@Override
	public void onPostLoad(PostLoadEvent event) {
		LOGGER.info("Key = 'postload' value = '{}'", event.getEntity());
	}

	@Override
	public boolean requiresPostCommitHanding(EntityPersister persister) {
		return false;
	}

	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		LOGGER.info("Key = '{}' value = '{}'", event.getClass(), event.getEntity());
		sendMessage(event.getEntity(), EAuditType.MOD);
	}

	@Override
	public boolean onPreDelete(PreDeleteEvent event) {
		LOGGER.info("Key = '{}' value = '{}'", event.getClass(), event.getEntity());
		sendMessage(event.getEntity(), EAuditType.DEL);
		return true;
	}

	@Override
	public void onPostInsert(PostInsertEvent event) {
		LOGGER.info("Key = '{}' value = '{}'", event.getClass(), event.getEntity());
		sendMessage(event.getEntity(), EAuditType.INS);

	}

	@Override
	public void onPostDelete(PostDeleteEvent event) {
		LOGGER.info("Key = '{}' value = '{}'", event.getClass(), event.getEntity());
		sendMessage(event.getEntity(), EAuditType.DEL);
	}

	@Override
	public void onPersist(PersistEvent event) throws HibernateException {
		LOGGER.info("Key = '{}' value = '{}'", event.getClass(), event.getObject());
		sendMessage(event.getObject(), EAuditType.INS);
	}

	@Override
	public void onPersist(PersistEvent event, Map createdAlready) throws HibernateException {
		LOGGER.info("Key = '{}' value = '{}'", event.getClass(), event.getObject());
		sendMessage(event.getObject(), EAuditType.INS);
	}

	private Long toLong(String usuarioid) {
		try {
			return Long.parseLong(usuarioid);
		} catch (Exception e) {
			LOGGER.warn("toLong", e);
		}
		return null;
	}

}
