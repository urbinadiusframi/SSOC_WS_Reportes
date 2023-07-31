package co.gov.ssoc.gedess.sgd.model.cfg;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBInitializationServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger("constantes-events");

	@Autowired
	private EntityManagerUtil entityManagerUtil;

	@PostConstruct
	public void initializeEntity() {

		Session session = entityManagerUtil.getEm().unwrap(Session.class);
		session.doWork(connection -> {
			try {
				String inputString = IOUtils.toString(
						this.getClass().getResourceAsStream("/ds/0.SiguienteCodigoTipoDocumental.sql"),
						StandardCharsets.UTF_8);
				String[] statements = inputString.split(";");
				for (String statement : statements) {
					executeUpdate(connection, statement);
				}
			} catch (Exception e) {
				LOGGER.error("post-construct", e);
			}
			try {
				String inputString = IOUtils.toString(this.getClass().getResourceAsStream("/ds/0.TIPOS.TODAS.sql"),
						StandardCharsets.UTF_8);
				String[] statements = inputString.split(";");
				for (String statement : statements) {
					executeUpdate(connection, statement);
				}
			} catch (Exception e) {
				LOGGER.error("post-construct", e);
			}
			try {
				String inputString = IOUtils.toString(
						this.getClass().getResourceAsStream("/ds/CKTramiteCodigoYNombre.sql"), StandardCharsets.UTF_8);
				String[] statements = inputString.split(";");
				for (String statement : statements) {
					executeUpdate(connection, statement);
				}
			} catch (Exception e) {
				LOGGER.error("post-construct", e);
			}
			try {
				String inputString = IOUtils.toString(
						this.getClass().getResourceAsStream("/ds/CKCuadernoCodigoYNombre.sql"), StandardCharsets.UTF_8);
				String[] statements = inputString.split(";");
				for (String statement : statements) {
					executeUpdate(connection, statement);
				}
			} catch (Exception e) {
				LOGGER.error("post-construct", e);
			}
			try {
				String inputString = IOUtils.toString(
						this.getClass().getResourceAsStream(
								"/ds/CREATE-PROCEDURE.[correspondencia].[SP_GET_CONSECUTIVE_RADICADO].sql"),
						StandardCharsets.UTF_8);
				String[] statements = inputString.split(";");
				for (String statement : statements) {
					executeUpdate(connection, statement);
				}
			} catch (Exception e) {
				LOGGER.error("post-construct", e);
			}
			try {
				String inputString = IOUtils.toString(
						this.getClass().getResourceAsStream("/ds/CREATE-SECUENCE.[correspondencia].[sqc_radicado].sql"),
						StandardCharsets.UTF_8);
				String[] statements = inputString.split(";");
				for (String statement : statements) {
					executeUpdate(connection, statement);
				}
			} catch (Exception e) {
				LOGGER.error("post-construct", e);
			}
//			try {
//				String inputString = IOUtils.toString(this.getClass().getResourceAsStream("/ds/0.enable-db-cdc.sql"),
//						StandardCharsets.UTF_8);
//				executeUpdate(connection, inputString);
//			} catch (Exception e) {
//				LOGGER.error("post-construct", e);
//			}
//			try {
//				String inputString = IOUtils.toString(this.getClass().getResourceAsStream("/ds/enable-cdc.sql"),
//						StandardCharsets.UTF_8);
////				String[] statements = inputString.split(";");
////				for (String statement : statements) {
//				executeUpdate(connection, inputString);
////				}
//			} catch (Exception e) {
//				LOGGER.error("post-construct", e);
//			}
		});
	}

	private void executeUpdate(Connection connection, String statementSQL) {
		try (Statement statement = connection.createStatement()) {
			statement.execute(statementSQL);
		} catch (Exception e) {
			LOGGER.error("execute-sql", e);
		}
	}
}
