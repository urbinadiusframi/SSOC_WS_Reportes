package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;

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
@Table(name = "Firmas_electronicas_Historial", schema = "correspondencia")
public class OFirmaElectronicaHistorico implements Serializable {

	private static final long serialVersionUID = 462161481116856825L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "numero_identificacion")
	private String numeroIdentificacion;
	@Column(name = "id_ldap")
	private String username;
	@Lob
	private byte[] firma;
	@Column(name = "fecha_cargue")
	private Date fechaCargue;
	private String accion;

}