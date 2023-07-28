package co.gov.ssoc.gedess.sgd.model.entity.repository;	

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.ODocumentosFirmadosFilenet;

@Repository
public interface DocumentosFirmadosFilenetRepository extends JpaRepository<ODocumentosFirmadosFilenet, Long> {
	
	@Query(value = "SELECT d FROM ODocumentosFirmadosFilenet d WHERE d.documentIdOriginal = :docid AND d.dateSigned IS NOT NULL")
	Optional<ODocumentosFirmadosFilenet> searchDocFirmado(@Param("docid") String docId);

	Optional<ODocumentosFirmadosFilenet> findByDocumentIdOriginal(String idDocumentOriginal);

}