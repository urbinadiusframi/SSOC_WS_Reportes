package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.ODisposicionFinal;

@Repository
public interface DisposicionFinalRepository extends JpaRepository<ODisposicionFinal, Long>
//, org.springframework.data.repository.history.RevisionRepository<ODisposicionFinal, Long, Long>>
{

	List<ODisposicionFinal> findByNombreIgnoreCaseIn(List<String> nombre);

	Optional<ODisposicionFinal> findByCodigo(Integer codigo);

	Optional<ODisposicionFinal> findByNombre(String nombre);
}