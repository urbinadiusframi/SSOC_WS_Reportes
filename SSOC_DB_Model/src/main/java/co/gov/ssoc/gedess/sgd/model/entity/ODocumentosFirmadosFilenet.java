package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Documentos_Firmados_Filenet", schema="correspondencia")
public class ODocumentosFirmadosFilenet implements Serializable {

	private static final long serialVersionUID = 2986091L;

	@Id
	@Column(name = "document_id_original")
	private String documentIdOriginal;
	
	@Column(name = "document_id_firmado")
	private String documentIdFirmado;
	
	@Column(name = "date_signed")
	private Date dateSigned;
	
	@PrePersist
	private void prePersistFunction() {
		this.dateSigned = new Date();
	}
}