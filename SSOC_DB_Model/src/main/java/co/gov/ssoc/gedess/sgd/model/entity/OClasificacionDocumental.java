package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "Clasificacion_Documental", schema="correspondencia")
public class OClasificacionDocumental implements Serializable {

	private static final long serialVersionUID = 29876809L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="id_radicado")
	private ORadicacion radicado;

	@Column(name = "codigo_dependencia")
	private String  codigoDependencia;

	@Column(name = "nombre_dependencia")
	private String  nombreDependencia;
	
	@Column(name = "codigo_serie")
	private String  codigoSerie;

	@Column(name = "nombre_serie")
	private String  nombreSerie;
	
	@Column(name = "codigo_subserie")
	private String  codigoSubSerie;

	@Column(name = "nombre_subserie")
	private String  nombreSubSerie;
	
	@Transient
	String tipoSerie;
}