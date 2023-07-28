package co.gov.ssoc.gedess.sgd.model.entity.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OSerieTipoDocumental;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumental;

@Repository
public interface SerieTipoDocumentalRepository extends JpaRepository<OSerieTipoDocumental, Long> //, org.springframework.data.repository.history.RevisionRepository<OSerieTipoDocumental, Long , Long>
{
	
	@Query(value = "SELECT d.serieTipoDocumentalPK.tipoDocumental.nombre FROM OSerieTipoDocumental d WHERE d.serieTipoDocumentalPK.trd.id = :idTrd ")
	List<String> searchTiposDocumentalesByTrd(@Param("idTrd") Long idTrd);
	
	@Query(value = "SELECT d.serieTipoDocumentalPK.tipoDocumental FROM OSerieTipoDocumental d WHERE d.serieTipoDocumentalPK.trd.id = :idTrd ")
	List<OTipoDocumental> searchTiposDocumentalesOfSerieByIdTrd(@Param("idTrd") Long idTrd);
}