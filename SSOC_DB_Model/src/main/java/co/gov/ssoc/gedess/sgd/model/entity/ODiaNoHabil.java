package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "DiaNoHabil", schema = "Administracion")
public class ODiaNoHabil implements Serializable {

	private static final long serialVersionUID = 42947L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "FechaInicio")
	private Date fechaInicio;
	@Column(name = "FechaFin")
	private Date fechaFin;
	private String descripcion;
	private Boolean estado;

}