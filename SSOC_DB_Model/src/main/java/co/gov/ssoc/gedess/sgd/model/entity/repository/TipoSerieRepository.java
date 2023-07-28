package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTipoSerie;

@Repository
public interface TipoSerieRepository extends JpaRepository<OTipoSerie, Long> //, org.springframework.data.repository.history.RevisionRepository<OTipoSerie, Long , Long>
{

	Optional<OTipoSerie> findByCodigoIgnoreCase(String codigo);

	Optional<OTipoSerie> findByCodigoIgnoreCaseOrNombreIgnoreCase(String codigo, String nombre);
}