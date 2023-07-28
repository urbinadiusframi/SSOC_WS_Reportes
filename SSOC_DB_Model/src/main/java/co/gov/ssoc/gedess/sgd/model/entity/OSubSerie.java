package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "SubSeries", schema = "Administracion")
public class OSubSerie implements Serializable {

	private static final long serialVersionUID = 42947L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private BigInteger codigo;
	@Column
	private String nombre;
	private Boolean estado;

	@Column(name = "serie_padre")
	private Long seriePadre;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "serie_padre", referencedColumnName = "ID", nullable = true, updatable = false, unique = false, insertable = false)
	private OSerie serie;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "SubSerieCuaderno", schema = "Administracion", joinColumns = @JoinColumn(name = "IdSubSerie"), inverseJoinColumns = @JoinColumn(name = "IdCuaderno"))
	private List<OTipoCuaderno> cuadernos;

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

	@PrePersist
	private void prePersistFunction() {
		this.estado = true;
		this.fechaCargue = new Date();
	}

}