package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.NamedStoredProcedureQuery;
//import javax.persistence.ParameterMode;
//import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
//@org.hibernate.envers.Audited
@Table(name = "Firma_Digital", schema = "correspondencia")
public class OFirmaDigital implements Serializable {

	private static final long serialVersionUID = 2986091L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "numero_radicado", unique = true)
	private String numeroRadicado;
	@Column(name = "documento_firmado", unique = true)
	private String documentoFirmado;
	@Column(name = "id_user")
	private BigInteger idUser;
	@Column(name = "id_app")
	private BigInteger idApp;

}
