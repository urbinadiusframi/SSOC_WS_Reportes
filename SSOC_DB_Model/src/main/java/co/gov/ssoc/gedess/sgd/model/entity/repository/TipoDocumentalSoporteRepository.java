package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumental;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumentalSoporte;

@Repository
public interface TipoDocumentalSoporteRepository extends JpaRepository<OTipoDocumentalSoporte, Long> //, org.springframework.data.repository.history.RevisionRepository<OTipoDocumentalSoporte, Long , Long>
{

	@Query(value = "SELECT d.tipoDocumentalSoportePK.soporte.nombreMedio FROM OTipoDocumentalSoporte d WHERE d.tipoDocumentalSoportePK.tipoDocumental = :tipoDoc ")
	List<String> searchSoportesByTipoDoc(@Param("tipoDoc") OTipoDocumental tipoDoc);
}