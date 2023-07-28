package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumental;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumentalCaracteristicas;

@Repository
public interface TipoDocumentalCaracteristicasRepository extends JpaRepository<OTipoDocumentalCaracteristicas, Long> //, org.springframework.data.repository.history.RevisionRepository<OTipoDocumentalCaracteristicas, Long , Long> 
{

	@Query(value = "SELECT d.tipoDocumentalCaracteristicaPK.caracteristica.nombre FROM OTipoDocumentalCaracteristicas d WHERE d.tipoDocumentalCaracteristicaPK.tipoDocumental = :tipoDoc ")
	List<String> searchCaracteByTipoDoc(@Param("tipoDoc") OTipoDocumental tipoDoc);
}