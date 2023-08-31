package co.gov.ssoc.gedess.sgd.cfg.audit;

public interface AuditRevisionListener {

	public static final String AUDIT_ENTIDAD = "AUDIT_ENTIDAD";
	public static final String AUDIT_ORIGIN_IP_ADDRESS = "originIpAddress";
	public static final String AUDIT_GUID_PROCESS = "guidProcess";
	public static final String AUDIT_VALUE = "AUDIT_VALUE";
	public static final String AUDIT_APLICATION = "AUDIT_APPLICATION";
	public static final String AUDIT_COMPONENT = "AUDIT_COMPONENT";
	public static final String AUDIT_PROGRAM = "AUDIT_PROGRAM";
	public static final String AUDIT_USER = "AUDIT_USER";
	public static final String AUDIT_USER_ID = "AUDIT_USER_ID";

	public void newRevision(Object entity);

	public static String getCurrentMethodName() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		if (stackTrace.length > 2) {
			StackTraceElement currentMethod = stackTrace[2];
			return currentMethod.getClassName() + "." + currentMethod.getMethodName();
		}
		return null;
	}

}
