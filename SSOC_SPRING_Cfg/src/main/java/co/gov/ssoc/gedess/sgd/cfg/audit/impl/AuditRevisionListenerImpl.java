package co.gov.ssoc.gedess.sgd.cfg.audit.impl;

import java.security.MessageDigest;
import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.ssoc.gedess.sgd.cfg.Constantes;
import co.gov.ssoc.gedess.sgd.cfg.audit.AuditRevisionListener;
import co.gov.ssoc.gedess.sgd.cfg.audit.dto.AuditoriaDTO;
import co.gov.ssoc.gedess.sgd.cfg.audit.dto.AuditoriaDTO.AuditoriaDTOBuilder;
import co.gov.ssoc.gedess.sgd.cfg.security.AuthTokenFilter;

@Service
public class AuditRevisionListenerImpl implements AuditRevisionListener {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private ObjectMapper objMapper;
	@Value("${spring.kafka.topic-auditable}")
	String auditoriaLogTopic;
	@Value("${application.name}")
	private String apiName;

	private static final Logger LOGGER = LoggerFactory.getLogger("audit-events");

	public static String calculateMD5Hash(AuditoriaDTO input) {
		try {
			String output = MessageFormat.format("{0}|{1}|{2}|{3:ddMMyyyyHHmmss}|{4}|{5}|{6}", input.getTipo(),
					input.getEntidad(), input.getIdentificador(), input.getFecha(), input.getUsuario(),
					input.getMaquina(), input.getContenido());
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] inputBytes = output.getBytes();
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

	@Override
	@Async("asyncTaskExecutorKafkaAuditable")
	public void newRevision(Object message) {
		String entidad = MDC.get(Constantes.AUDIT_ENTIDAD);
		String value = MDC.get(Constantes.AUDIT_VALUE);
		String comp = MDC.get(Constantes.AUDIT_COMPONENT);
		String usuario = MDC.get(Constantes.AUDIT_COMPONENT);
		String usuarioid = MDC.get(Constantes.AUDIT_COMPONENT);
		String process = MDC.get(AuthTokenFilter.GUID_PROCESS);
		String ipAddress = MDC.get(AuthTokenFilter.ORIGIN_IP_ADDRESS);
		AuditoriaDTO input = (AuditoriaDTO) message;
		AuditoriaDTOBuilder auditBuilder = AuditoriaDTO.builder();
		try {
			auditBuilder.aplicacion(apiName).componente(comp).contenido(input.getContenido()).entidad(entidad)
					.fecha(input.getFecha()).identificador(process).maquina(ipAddress).tipo(input.getTipo())
					.usuario(usuario).usuarioId(toLong(usuarioid)).build();
		} catch (Exception e) {
			LOGGER.error("build", e);
		}
		try {
			auditBuilder.comprobacion(calculateMD5Hash(input));
		} catch (Exception e) {
			LOGGER.error("calculate-md5-hash", e);
		}
		try {
			kafkaTemplate.send(auditoriaLogTopic, objMapper.writeValueAsString(auditBuilder.build()));
		} catch (Exception e) {
			LOGGER.error("send", e);
		}
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
