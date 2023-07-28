package co.gov.ssoc.gedess.sgd.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Builder
@Table(name = "CuadroClasificacionDocumental", schema = "Administracion")
public class OCuadroClasificacionDocumental {
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

	private Boolean estado;

	@Column(name = "FechaCargue")
	private Date fechaCargue;

	@Column(name = "FechaInactivacion")
	private Date fechaInactivacion;

	@Column(name = "Version")
	private Integer version;

	@Column(name = "NombreActoAdministrativo")
	private String nombreActoAdministrativo;

	@Column(name = "NumeroActoAdministrativo")
	private Integer numeroActoAdministrativo;

	@Column(name = "FechaActoAdministrativo")
	private Date fechaActoAdministrativo;

	@Column(name = "Observaciones")
	private String observaciones;

	@PrePersist
	private void prePersistFunction() {
		this.estado = true;
		this.fechaCargue = new Date();
	}
}
