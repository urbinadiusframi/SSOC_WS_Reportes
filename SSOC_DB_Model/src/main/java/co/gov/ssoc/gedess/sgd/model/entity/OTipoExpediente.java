package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TipoExpediente", schema = "Administracion")
public class OTipoExpediente implements Serializable {

	private static final long serialVersionUID = 42947L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Codigo", unique = true)
	private String codigo;

	@Column(name = "Nombre", unique = true)
	private String nombre;

	@Column(name = "FechaCargue")
	private Date fechaCargue;

	@PrePersist
	private void prePersistFunction() {
		this.fechaCargue = new Date();
	}

}