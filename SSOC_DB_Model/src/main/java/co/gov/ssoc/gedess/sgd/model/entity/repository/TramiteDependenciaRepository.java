package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTramite;
import co.gov.ssoc.gedess.sgd.model.entity.OTramitesRelaDependencia;

@Repository
public interface TramiteDependenciaRepository extends JpaRepository<OTramitesRelaDependencia, Long> {

	@Query("SELECT o.tramiteRelaDependencia.tramite FROM OTramitesRelaDependencia o WHERE o.tramiteRelaDependencia.tramite.codigo = :codigoTramite  AND o.tramiteRelaDependencia.codigoGrupoTrabajo = :codigoGrupoTrabajo")
	Optional<OTramite> findTramiteByDependencia(Integer codigoTramite, Integer codigoGrupoTrabajo);

	@Query("SELECT o FROM OTramitesRelaDependencia o WHERE o.tramiteRelaDependencia.tramite.codigo = :codigoTramite ")
	Optional<List<OTramitesRelaDependencia>> findDependenciasByCodigoTramite(Integer codigoTramite);

	@Query("SELECT o.tramiteRelaDependencia.nombreGrupoTrabajo, o.tramiteRelaDependencia.codigoGrupoTrabajo FROM OTramitesRelaDependencia o WHERE o.tramiteRelaDependencia.tramite.codigo = :codigoTramite  AND o.tramiteRelaDependencia.codigoGrupoTrabajo = :codigoGrupoTrabajo")
	Optional<Object[]> findGrupoByTramiteAndDependencia(Integer codigoTramite, Integer codigoGrupoTrabajo);

}