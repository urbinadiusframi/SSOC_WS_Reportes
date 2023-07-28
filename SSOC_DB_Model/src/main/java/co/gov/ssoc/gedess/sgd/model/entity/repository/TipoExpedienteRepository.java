package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTipoExpediente;

@Repository
public interface TipoExpedienteRepository extends JpaRepository<OTipoExpediente, Long> //, org.springframework.data.repository.history.RevisionRepository<OTipoExpediente, Long , Long>
{

	Optional<OTipoExpediente> findByCodigoIgnoreCase(String codigo);

	List<OTipoExpediente> findByCodigoIgnoreCaseOrNombreIgnoreCase(String codigo, String nombre);
}