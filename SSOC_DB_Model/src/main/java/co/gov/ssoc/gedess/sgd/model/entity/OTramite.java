package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "TramiteRelaciones", schema = "correspondencia")
public class OTramite implements Serializable {

	private static final long serialVersionUID = 112312L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer codigo;
	private String nombre;
	@Column(name = "codigo_grupo_trabajo")
	private Integer codigoGrupoTrabajo;
	@Column(name = "nombre_grupo_trabajo")
	private String nombreGrupoTrabajo;
	private Boolean estado;
	@Column(name = "termino_dias")
	private Integer terminoDias;
	@Column(name = "termino_modificable")
	private Boolean terminoModificable;
	@Column(name = "fecha_cargue", columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Date fechaCargue;
	@ManyToOne
	@JoinColumn(name = "proceso_id")
	private OProceso proceso;
	@ManyToOne
	@JoinColumn(name = "tipo_documental_id")
	private OTipoDocumental tipoDocumental;
	@ManyToOne
	@JoinColumn(name = "radicacion_id")
	private OTipoRadicacion radicacion;
	@ManyToOne
	@JoinColumn(name = "tipo_expediente_id")
	private OTipoExpediente expediente;
	@ManyToOne
	@JoinColumn(name = "serie_id")
	private OSerie serie;
	@ManyToOne
	@JoinColumn(name = "subserie_id")
	private OSubSerie subserie;
	@ManyToOne
	@JoinColumn(name = "cuaderno_id")
	private OTipoCuaderno cuaderno;
	@ManyToOne
	@JoinColumn(name = "seguridad_id")
	private OTipoSeguridad seguridad;

	@PrePersist
	private void prePersistFunction() {
		this.estado = true;
		this.setFechaCargue(new Date());
	}

}