package co.gov.ssoc.gedess.sgd.model.entity.repository;	

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTipoRadicacion;
import co.gov.ssoc.gedess.sgd.model.entity.OTramite;
import co.gov.ssoc.gedess.sgd.model.entity.OTramites_Tipo_Radicacion;

@Repository
public interface TramiteTipoRadicacionRepository extends JpaRepository<OTramites_Tipo_Radicacion, Long> {

	@Query("SELECT o.tramiteTipoRadic.tramite FROM OTramites_Tipo_Radicacion o WHERE o.tramiteTipoRadic.tipoRadicacion = :tipoRad")
	List<OTramite> findTramitesByTipoRadicacion(@Param("tipoRad") OTipoRadicacion oTipoRadicacion);

	@Query("SELECT o.tramiteTipoRadic.tramite FROM OTramites_Tipo_Radicacion o WHERE o.tramiteTipoRadic.tipoRadicacion = :tipoRad AND o.tramiteTipoRadic.tramite.codigo = :codigo")
	List<OTramite> findTramitesByCodigoAndTipoRadicacion(@Param("codigo") Integer codigo,
			@Param("tipoRad") OTipoRadicacion oTipoRadicacion);

}