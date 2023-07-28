package co.gov.ssoc.gedess.sgd.model.entity.repository;	

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ssoc.gedess.sgd.model.entity.ODocumentosFilenet;
import co.gov.ssoc.gedess.sgd.model.entity.ORadicacion;

@Repository
public interface DocumentFilenetRepository extends JpaRepository<ODocumentosFilenet, Long> {
	

	@Query(value = "EXEC correspondencia.SP_INSERT_DOCUMENTO_FILENET " + 
			" :numero_radicacion,  :type_document, " + 
			" :document_id,        :folder_id, " + 
			" :name_document,      :mime_type, " + 
			" :version_principal,  :date_upload, " + 
			" :upload_by,          :modify_date, " + 
			" :modify_by,          :huella_digital, " + 
			" :document_state,     :version_menor  ,  :respuesta" , nativeQuery = true )
	@Transactional
	String spInsertDocumentoFilenet(@Param("numero_radicacion") String numero_radicacion,@Param("type_document") String type_document
			,@Param("document_id") String document_id,@Param("folder_id") String folder_id,@Param("name_document") String name_document,
			@Param("mime_type") String mime_type, @Param("version_principal") Integer version_principal,@Param("date_upload") Date date_upload,
			@Param("upload_by") String upload_by,@Param("modify_date") Date modify_date,@Param("modify_by") String modify_by,
			@Param("huella_digital") String huella_digital,@Param("document_state") String document_state,
			@Param("version_menor") Integer version_menor,@Param("respuesta") String respuesta);
	
	Optional<List<ODocumentosFilenet>> findTop100ByNumberRadicadoAndTypeDocumentOrderByDateUploadDesc(ORadicacion radicado,String typeDocument);
	Optional<List<ODocumentosFilenet>> findByNumberRadicado(ORadicacion radicado);
	Optional<ODocumentosFilenet> findByNumberRadicadoAndNameDocument(ORadicacion radicado,String nameDocument);
	Optional<ODocumentosFilenet> findByNameDocument(String nameDocument);
	Optional<ODocumentosFilenet> findByNumberRadicadoOrderByDocumentId(String numeroRadicado);
	Optional<ODocumentosFilenet> findTop1ByNumberRadicadoAndHuellaDigitalOrderByDateUploadDesc(ORadicacion radicado,String huellaDigital);

//	Optional<ODocumentos_Filenet> findByVersionAndNameDocument(ORadicacion radicado,String nameDocument);
	Optional<List<ODocumentosFilenet>> findTop100ByTypeDocumentOrderByDateUploadDesc(String typeDocument);
	
	Optional<ODocumentosFilenet> findByDocumentId(String documentId);

}