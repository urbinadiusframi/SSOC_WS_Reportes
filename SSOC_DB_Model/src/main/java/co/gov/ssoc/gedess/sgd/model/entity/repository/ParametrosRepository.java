package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OParametros;

@Repository
public interface ParametrosRepository extends JpaRepository<OParametros, Long> {

	Optional<List<OParametros>> findByGrupo(String grupo);
	Optional<List<OParametros>> findByGrupoAndEstadoOrderByNombreAsc(String grupo,Boolean estado);
	Optional<OParametros> findTop1ByGrupoAndNombreIgnoreCaseAndEstadoOrderByFechaCreacionDesc(String grupo,String nombre,Boolean estado);
	Optional<OParametros> findTop1ByGrupoAndCodigoAndEstadoOrderByFechaCreacionDesc(String grupo,String codigo,Boolean estado);
}