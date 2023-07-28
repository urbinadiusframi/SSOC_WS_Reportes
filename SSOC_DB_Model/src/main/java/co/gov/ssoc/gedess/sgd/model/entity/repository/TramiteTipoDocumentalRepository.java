package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumental;
import co.gov.ssoc.gedess.sgd.model.entity.OTramiteRelaTipoDocumental;

@Repository
public interface TramiteTipoDocumentalRepository extends JpaRepository<OTramiteRelaTipoDocumental, Long> {

	@Query("SELECT o.tramiteTipoDocumental.tipoDocumental FROM OTramiteRelaTipoDocumental o WHERE o.tramiteTipoDocumental.tramite.codigo = :codigoTramite ")
	List<OTipoDocumental> findTipoDocumentalByCodigoTramite(Integer codigoTramite);
}