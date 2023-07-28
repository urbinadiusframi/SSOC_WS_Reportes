package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OSubSerieTipoDocumental;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumental;

@Repository
public interface SubSerieTipoDocumentalRepository extends JpaRepository<OSubSerieTipoDocumental, Long> //, org.springframework.data.repository.history.RevisionRepository<OSubSerieTipoDocumental, Long , Long>
{

	@Query(value = "SELECT d.subSerieTipoDocumentalPK.tipoDocumental.nombre FROM OSubSerieTipoDocumental d WHERE d.subSerieTipoDocumentalPK.trd.id = :idTrd ")
	List<String> searchTiposDocumentalesByTrd(@Param("idTrd") Long idTrd);

	@Query(value = "SELECT d.subSerieTipoDocumentalPK.tipoDocumental FROM OSubSerieTipoDocumental d WHERE d.subSerieTipoDocumentalPK.trd.id = :idTrd ")
	List<OTipoDocumental> searchTiposDocumentalesOfSerieByIdTrd(@Param("idTrd") Long idTrd);
}