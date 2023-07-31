package co.gov.ssoc.gedess.sgd.cfg;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Constantes {

	private static final String FORMATO_FECHA_QUERY = "yyyy-MM-dd hh:mm";
	private static final String ESTADO_ACTIVA = "Activa";
	private static final String ESTADO_INACTIVA = "Inactiva";
	private static final String ESTADO_ACTIVO = "Activo";
	private static final String ESTADO_INACTIVO = "Inactivo";
	private SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat(FORMATO_FECHA_QUERY);
	private static final String SEPARADOR_ERRORES = ", ";

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public boolean isAlpha(String name) {
		return name.matches("[\\p{L} ]+");
	}

	public static String getCurrentMethodName() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		if (stackTrace.length > 2) {
			// The method name is present at index 2 of the stack trace
			StackTraceElement currentMethod = stackTrace[2];
			return currentMethod.getClassName() + "." + currentMethod.getMethodName();
		}
		return null;
	}

	public static final String AUDIT_ENTIDAD = "AUDIT_ENTIDAD";
	public static final String AUDIT_VALUE = "AUDIT_VALUE";
	public static final String AUDIT_COMPONENT = "AUDIT_COMPONENT";
	public static final String AUDIT_USER = "AUDIT_USER";
	public static final String AUDIT_USER_ID = "AUDIT_USER_ID";

	private Integer toInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return null;
		}
	}

	private Long toLong(String value) {
		try {
			return Long.parseLong(value);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean validarFecha(String fecha) {
		boolean estado = false;

		if (!this.isValidString(fecha)) {

			return estado;
		}
		try {
			FORMATO_FECHA.parse(fecha);
			estado = true;
		} catch (ParseException e) {
			estado = false;
		}
		return estado;
	}

	private boolean isValidString(String stringNew) {
		if (stringNew == null) {
			return false;
		}
		if (stringNew.trim().isEmpty()) {
			return false;
		}
		return true;
	}

}
