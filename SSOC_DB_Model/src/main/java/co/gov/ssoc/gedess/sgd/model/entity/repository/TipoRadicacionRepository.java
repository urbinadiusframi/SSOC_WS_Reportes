package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTipoRadicacion;

@Repository
public interface TipoRadicacionRepository extends JpaRepository<OTipoRadicacion, Long> //, org.springframework.data.repository.history.RevisionRepository<OTipoRadicacion, Long , Long>
{

	Optional<OTipoRadicacion> findByCodigoOrNombre(Integer codigo, String nombre);

	List<OTipoRadicacion> findAllByCodigoOrNombreIgnoreCase(Integer codigo, String nombre);

	Optional<OTipoRadicacion> findByCodigoOrNombreIgnoreCase(Integer codigo, String nombre);

	Optional<OTipoRadicacion> findByNombre(String nombre);

	List<OTipoRadicacion> findByNombreIgnoreCaseIn(String[] tiposRadicacion);
}