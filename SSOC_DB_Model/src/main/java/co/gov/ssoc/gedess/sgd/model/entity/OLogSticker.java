package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "Log_generacion_sticker", schema = "correspondencia")
public class OLogSticker implements Serializable {

	private static final long serialVersionUID = 11987L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "numero_radicado")
	private String numeroRadicado;
	@Column(name = "numero_proceso")
	private String numeroProceso;
	@Column(name = "formato")
	private String formato;
	@Column(name = "generado_por")
	private String generadoPor;
	@Column(name = "fecha_generacion")
	private Date fechaGeneracion;
	@Column(name = "fecha_estampado")
	private Date fechaEstampado;

	@PrePersist
	private void prePersistFunction() {
		this.fechaGeneracion = new Date();
	}
}