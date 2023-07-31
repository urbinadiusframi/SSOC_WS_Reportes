package co.gov.ssoc.gedess.sgd.cfg.audit.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriaDTO {

	private String usuario;
	private Long usuarioId;
	private String aplicacion;
	private EAuditType tipo;
	private String entidad;
	private String identificador;
	private String programa;
	private String componente;
	private Date fecha;
	private String maquina;
	private String contenido;
	private String comprobacion;
}
