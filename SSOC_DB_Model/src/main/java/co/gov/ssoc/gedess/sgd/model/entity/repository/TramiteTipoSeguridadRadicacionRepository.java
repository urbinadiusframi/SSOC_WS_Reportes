package co.gov.ssoc.gedess.sgd.model.entity.repository;	

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTramite;
import co.gov.ssoc.gedess.sgd.model.entity.OTramites_Tipo_Radicacion_Seguridad;

@Repository
public interface TramiteTipoSeguridadRadicacionRepository
		extends JpaRepository<OTramites_Tipo_Radicacion_Seguridad, Long>,
		JpaSpecificationExecutor<OTramites_Tipo_Radicacion_Seguridad> {

	@Query("SELECT o FROM OTramites_Tipo_Radicacion_Seguridad o WHERE o.tramiteRadSeg.tramite = :tramite")
	Optional<List<OTramites_Tipo_Radicacion_Seguridad>> findByTramiteRadSegTramite(@Param("tramite") OTramite tramite);
	// Optional<OTramites_Tipo_Radicacion_Seguridad>
	// findByid_tipo_seguridad(Optional<OTipoSeguridad> tipoSeguridad);

}