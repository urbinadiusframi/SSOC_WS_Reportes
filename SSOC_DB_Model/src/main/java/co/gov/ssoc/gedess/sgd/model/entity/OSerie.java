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
@Table(name = "Series", schema = "Administracion")
public class OSerie implements Serializable {

	private static final long serialVersionUID = 42947L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private Integer codigo;
	@Column(unique = true)
	private String nombre;
	private String descripcion;
	private Boolean estado;

	@Column(name = "serie_padre")
	private Long seriePadre;

	@Column(name = "fecha_cargue")
	private Date fechaCargue;

	@Column(name = "ActoAdministrativo")
	private String actoAdministrativo;

	@ManyToOne
	@JoinColumn(name = "IdMotivo")
	private OMotivos motivo;

	@Column(name = "FechaInactivacion")
	private Date fechaInactivacion;

	private String observaciones;

	@Column(name = "NivelClasificacion")
	private Integer nivelClasificacion;

//	@Version
//	Long version;

	@PrePersist
	private void prePersistFunction() {
		this.estado = true;
		this.fechaCargue = new Date();
	}

}