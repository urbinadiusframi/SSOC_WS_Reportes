package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
//import javax.persistence.NamedStoredProcedureQuery;
//import javax.persistence.ParameterMode;
//import javax.persistence.StoredProcedureParameter;
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
@Table(name = "Documentos_Filenet", schema = "correspondencia")
/*
 * @NamedStoredProcedureQuery(name = "ODocumentosFilenet.insertarDocFilenet",
 * procedureName = "correspondencia.SP_INSERT_DOCUMENTO_FILENET", parameters = {
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name =
 * "numero_radicacion", type = String.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "type_document",
 * type = String.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "document_id", type
 * = String.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "folder_id", type =
 * String.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "name_document",
 * type = String.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "mime_type", type =
 * String.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name =
 * "version_principal", type = Integer.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "date_upload", type
 * = Date.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "upload_by", type =
 * String.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "modify_date", type
 * = Date.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "modify_by", type =
 * String.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "huella_digital",
 * type = String.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "document_state",
 * type = String.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "version_menor",
 * type = Integer.class),
 * 
 * @StoredProcedureParameter(mode = ParameterMode.OUT, name = "respuesta", type
 * = String.class) })
 */
public class ODocumentosFilenet implements Serializable {

	private static final long serialVersionUID = 2986091L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_radicado")
	private ORadicacion numberRadicado;
	@Column(name = "type_document")
	private String typeDocument;
	@Column(name = "document_id")
	private String documentId;
	@Column(name = "folder_id")
	private String folderId;

	@Column(name = "huella_digital")
	private String huellaDigital;

	@Column(name = "name_document")
	private String nameDocument;
	@Column(name = "mime_type")
	private String mimeType;
	@Column(name = "version_principal")
	private String versionPrincipal;
	@Column(name = "version_menor")
	private String versionMenor;
	@Column(name = "date_upload")
	private Date dateUpload;
	@Column(name = "upload_by")
	private String uploadBy;
	@Column(name = "modify_date")
	private Date modifyDate;
	@Column(name = "modify_by")
	private String modifyBy;
	@Column(name = "document_state")
	private String documentState;

	@PrePersist
	private void prePersistFunction() {
		this.dateUpload = new Date();
	}
}