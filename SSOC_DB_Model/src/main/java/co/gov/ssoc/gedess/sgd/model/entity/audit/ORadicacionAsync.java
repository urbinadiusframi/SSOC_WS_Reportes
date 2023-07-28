package co.gov.ssoc.gedess.sgd.model.entity.audit;

import java.io.Serializable;

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
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@org.hibernate.envers.Audited
@Table(name = "RadicacionesAsync", schema = "correspondencia")
public class ORadicacionAsync implements Serializable {

	private static final long serialVersionUID = 2909L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "identificador")
	private String identificador;

	@Column(name = "number_radicado", unique = true)
	private String numberRadicado;

	@Column(name = "fila")
	private Integer fila;

	@Column(name = "http_status")
	private Integer httpStatus;

	@Column(name = "mensaje")
	private String mensaje;

}
