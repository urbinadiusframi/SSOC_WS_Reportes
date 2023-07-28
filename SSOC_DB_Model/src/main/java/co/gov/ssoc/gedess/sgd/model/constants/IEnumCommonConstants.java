package co.gov.ssoc.gedess.sgd.model.constants;

public interface IEnumCommonConstants {

	public static final String PREFIX_AUTH = "basic";
	public static final String PREFIX_AUTH_BEARER = "bearer";

	public enum TiposRadicacionEnum {
		ENTRADA, INTERNA, SALIDA;
	}

	public enum ResponseEnum {

		RSP_OK("00", "Creado correctamente"), RSP_OK_EDIT("00", "Editado correctamente"),
		RSP_OK_INACTIVAR("00", "Inactivado correctamente"), RSP_BAD_LISTAR("02", "No existe valores"),
		RSP_BAD_FIND_REGISTER("03", "No existe el valor buscado"),
		RSP_BAD_FIND_REDUNDANCY("04", "El valor nuevo ya existe");

		private String code;
		private String message;

		private ResponseEnum(String code, String message) {
			this.code = code;
			this.message = message;
		}

		public String getCode() {
			return this.code;
		}

		public String getMessage() {
			return this.message;
		}
	}

}
