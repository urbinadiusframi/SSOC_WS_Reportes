package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OMotivos;

@Repository
public interface MotivosRepository extends JpaRepository<OMotivos, Long>
//, org.springframework.data.repository.history.RevisionRepository<OMotivos, Long, Long>>
{

	Optional<OMotivos> findByIdOrNombre(Long id, String nombre);
}