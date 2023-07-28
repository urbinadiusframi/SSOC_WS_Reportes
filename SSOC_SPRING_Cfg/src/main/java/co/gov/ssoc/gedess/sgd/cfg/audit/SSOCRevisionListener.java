package co.gov.ssoc.gedess.sgd.cfg.audit;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Profile;

import co.gov.ssoc.gedess.sgd.cfg.Constantes;
import co.gov.ssoc.gedess.sgd.model.entity.audit.OAudit;

@Profile("!prod")
public class SSOCRevisionListener 
//implements org.hibernate.envers.RevisionListener 
{

	private static final Logger LOGGER = LoggerFactory.getLogger(SSOCRevisionListener.class);

//	@Override
	public void newRevision(Object entity) {
		if (entity instanceof OAudit) {
			String entidad = MDC.get(Constantes.AUDIT_ENTIDAD);
			String value = MDC.get(Constantes.AUDIT_VALUE);
			String comp = MDC.get(Constantes.AUDIT_COMPONENT);
			OAudit revisionEntity = (OAudit) entity;
			revisionEntity.setComponente(comp);
			revisionEntity.setEntidad(entidad);
			revisionEntity.setContenido(value);
//			String comprobacion = calculateMD5Hash(String.format("{0}|{1}|{2}|{3:ddMMyyyyHHmmss}|{4}|{5}|{6}",
//					TipoAuditoria, entidad, identificador, fecha, usuario, maquina, contenido));
//			revisionEntity.setComprobacion(comprobacion);

		}
	}

	public static String calculateMD5Hash(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] inputBytes = input.getBytes();
			byte[] hashBytes = md.digest(inputBytes);
			StringBuilder sb = new StringBuilder();
			for (byte b : hashBytes) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (Exception e) {
			LOGGER.error("calculate-md5-hash", e);
			return null;
		}
	}

}
