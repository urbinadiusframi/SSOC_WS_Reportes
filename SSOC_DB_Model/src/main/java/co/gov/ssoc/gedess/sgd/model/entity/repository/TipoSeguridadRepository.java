package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTipoSeguridad;

@Repository
public interface TipoSeguridadRepository extends JpaRepository<OTipoSeguridad, Long> //, org.springframework.data.repository.history.RevisionRepository<OTipoSeguridad, Long , Long>
{

	Optional<List<OTipoSeguridad>> findByEstado(Boolean estado);
	Optional<OTipoSeguridad> findByCodigoIgnoreCase(String codigo);
	Optional<OTipoSeguridad> findByNombreIgnoreCaseAndEstado(String nombre,Boolean estado);
	Optional<OTipoSeguridad> findByNombreIgnoreCase(String nombre);
	
	List<OTipoSeguridad> findByCodigoIgnoreCaseIn(List<String> tipoSeguridad); 
	
	@Query(value = "SELECT NEXT VALUE FOR correspondencia.sqc_tipo_seguridad", nativeQuery = true)
	public Integer getNextValSequenceTipoSeguridad();
}