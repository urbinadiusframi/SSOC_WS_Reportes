package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

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
@Table(name = "DisposicionFinal", schema = "Administracion")
public class ODisposicionFinal implements Serializable {

	private static final long serialVersionUID = -51326814609928L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String nombre;
	@Column(name = "FechaInactivacion")
	private Date fechaInactivacion;
	@Column(name = "Codigo", nullable = true)
	private Integer codigo;
	private Boolean estado;

}