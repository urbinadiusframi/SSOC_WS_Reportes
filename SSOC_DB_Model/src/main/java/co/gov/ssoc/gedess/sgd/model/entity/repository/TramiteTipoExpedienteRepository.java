package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTipoExpediente;
import co.gov.ssoc.gedess.sgd.model.entity.OTramitesRelaTipoExpediente;

@Repository
public interface TramiteTipoExpedienteRepository extends JpaRepository<OTramitesRelaTipoExpediente, Long>,
		JpaSpecificationExecutor<OTramitesRelaTipoExpediente> {

	@Query("SELECT o.tramiteTipoExpediente.tipoExpediente FROM OTramitesRelaTipoExpediente o WHERE o.tramiteTipoExpediente.tramite.codigo = :codigoTramite and o.tramiteTipoExpediente.tramite.estado = true")
	Optional<OTipoExpediente> findTipoExpedienteByCodigoTramite(Integer codigoTramite);

	@Query("SELECT o.tramiteTipoExpediente.tipoExpediente FROM OTramitesRelaTipoExpediente o WHERE o.tramiteTipoExpediente.tramite.codigo = :codigoTramite and o.tramiteTipoExpediente.tramite.estado = true")
	List<OTipoExpediente> findTiposExpedienteByCodigoTramite(Integer codigoTramite);
}