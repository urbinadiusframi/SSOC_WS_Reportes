package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

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
@Table(name = "Tipos_Cuaderno", schema = "Administracion")
public class OTipoCuaderno implements Serializable {

	private static final long serialVersionUID = 112321L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer codigo;
	private String nombre;
	@Column(name = "fecha_cargue")
	private Date fechaCargue;
	@Column(name = "FechaInactivacion")
	private Date fechaInactivacion;

	@PrePersist
	private void prePersistFunction() {
		this.setFechaCargue(new Date());
	}
}