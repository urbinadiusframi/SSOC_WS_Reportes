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
@Table(name = "TipoSerie", schema = "Administracion")
public class OTipoSerie implements Serializable {

	private static final long serialVersionUID = 429471231L;

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