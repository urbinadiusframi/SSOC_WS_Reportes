package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Builder
@Table(name = "TablasRetencionDocumental", schema = "Administracion")
public class OTablaRetencionDocumental implements Serializable {

	private static final long serialVersionUID = 429412347L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CodigoUnidadAdministrativa")
	private Integer codigoUnidadAdministrativa;

	@Column(name = "NombreUnidadAdministrativa")
	private String nombreUnidadAdministrativa;

	@Column(name = "CodigoOficinaProductora")
	private Integer codigoOficinaProductora;

	@Column(name = "NombreOficinaProductora")
	private String nombreOficinaProductora;

	@ManyToOne
	@JoinColumn(name = "IdSerie")
	private OSerie serie;

	@ManyToOne
	@JoinColumn(name = "IdSubserie")
	private OSubSerie subSerie;

	@Column(name = "TiempoRetencionGestion")
	private Integer tiempoRetencionGestion;

	@Column(name = "TiempoRetencionCentral")
	private Integer tiempoRetencionCentral;

	@Lob
	private String procedimiento;

	private String observaciones;

	@Column(name = "NombreActoAdministrativo")
	private String nombreActoAdministrativo;

	@Column(name = "NumeroActoAdministrativo")
	private Integer numeroActoAdministrativo;

	@Column(name = "FechaActoAdministrativo")
	private Date fechaActoAdministrativo;

	@Column(name = "FechaCargue")
	private Date fechaCargue;

	private Boolean estado;

	@Column(name = "FechaInactivacion")
	private Date fechaInactivacion;

	@Column(name = "Version")
	private Integer version;

	@Column(name = "CodigoSerie")
	private String codigoSerie;

	@Column(name = "CodigoSubSerie")
	private String codigoSubSerie;

	@PrePersist
	private void prePersistFunction() {
		this.estado = true;
		this.fechaCargue = new Date();
	}

}