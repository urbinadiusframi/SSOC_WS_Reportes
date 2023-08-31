package co.gov.ssoc.gedess.sgd.cfg.audit.impl;

import java.security.MessageDigest;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.ssoc.gedess.sgd.cfg.audit.AuditRevisionListener;
import co.gov.ssoc.gedess.sgd.cfg.audit.dto.AuditoriaDTO;
import co.gov.ssoc.gedess.sgd.cfg.audit.dto.AuditoriaDTO.AuditoriaDTOBuilder;

@Service
public class AuditRevisionListenerImpl implements AuditRevisionListener {

//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private RabbitTemplate template;
	@Autowired
	private Queue queue;
	// ddMMyyyyHHmmss
	private static SimpleDateFormat sfd1 = new SimpleDateFormat("ddMMyyyyHHmmssZ");

	@Autowired
	private ObjectMapper objMapper;
	@Value("${spring.kafka.topic-auditable}")
	String auditoriaLogTopic;
	@Value("${application.name}")
	private String apiName;

	private static final Logger LOGGER = LoggerFactory.getLogger("audit-events");

	public static String calculateMD5Hash(AuditoriaDTO input) {
		try {
			String output = MessageFormat.format("{0}|{1}|{2}|{3}|{4}|{5}|{6}", input.getTipo(), input.getEntidad(),
					input.getIdentificador(), sfd1.format(input.getFecha()), input.getUsuario(), input.getMaquina(),
					input.getContenido());
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
		AuditoriaDTO input = (AuditoriaDTO) message;
		AuditoriaDTOBuilder auditBuilder = AuditoriaDTO.builder();
		try {
			auditBuilder.programa(apiName).aplicacion(input.getAplicacion()).componente(input.getComponente())
					.usuario(input.getUsuario()).usuarioId(input.getUsuarioId()).maquina(input.getMaquina())
					.contenido(input.getContenido()).entidad(input.getEntidad()).fecha(input.getFecha())
					.identificador(input.getIdentificador()).tipo(input.getTipo()).build();
		} catch (Exception e) {
			LOGGER.error("build", e);
		}
		try {
			auditBuilder.comprobacion(calculateMD5Hash(input));
		} catch (Exception e) {
			LOGGER.error("calculate-md5-hash", e);
		}
//		try {
//			kafkaTemplate.send(auditoriaLogTopic, objMapper.writeValueAsString(auditBuilder.build()));
//		} catch (Exception e) {
//			LOGGER.error("send", e);
//		}
		try {
			send(objMapper.writeValueAsString(auditBuilder.build()));
		} catch (Exception e) {
			LOGGER.error("send", e);
		}
	}

	public void send(String message) {
		this.template.convertAndSend(queue.getName(), message);
		LOGGER.info("Sent {}", message);
	}
}
