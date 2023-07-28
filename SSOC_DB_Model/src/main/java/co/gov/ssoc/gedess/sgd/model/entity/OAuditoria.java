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
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "Auditoria", schema = "Administracion")
public class OAuditoria implements Serializable {

	private static final long serialVersionUID = 11122L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	@Column(name = "Modulo")
	private String modulo;
	@Column(name = "Dependencia")
	private String dependencia;
	@Column(name = "TipoAccion")
	private String tipoAccion;
	@Version
	@Column(name = "Version")
	private long version;
	@Column(name = "Usuario")
	private String usuario;
	@Column(name = "FechaCargue")
	private Date fechaCargue;
	@Column(name = "FechaInicio")
	private Date fechaInicio;
	@Column(name = "FechaFin")
	private Date fechaFin;

	@PrePersist
	private void prePersistFunction() {
		this.fechaCargue = new Date();
	}
}
