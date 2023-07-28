package co.gov.ssoc.gedess.sgd.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "SerieDisposicionFinal", schema = "Administracion")
public class ODisposicionFinalSerie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5216069833634330645L;

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

	@Column(name = "Observaciones")
	private String observaciones;

	private Boolean estado;

	@Column(name = "FechaCargue")
	private Date fechaCargue;

	@Column(name = "FechaInactivacion")
	private Date fechaInactivacion;

	@Column(name = "Version")
	private Integer version;

	@PrePersist
	private void prePersistFunction() {
		this.estado = true;
		this.fechaCargue = new Date();
	}
}
