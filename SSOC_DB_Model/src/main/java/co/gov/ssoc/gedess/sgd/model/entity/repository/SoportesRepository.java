package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OSoportes;

@Repository
public interface SoportesRepository extends JpaRepository<OSoportes, Long> //, org.springframework.data.repository.history.RevisionRepository<OSoportes, Long , Long>
{	

	Optional<OSoportes> findByIdOrNombreMedioIgnoreCase(Long codigo, String nombreMedio);
	List<OSoportes> findByNombreMedioIgnoreCaseIn(List<String> nombre);
	Optional<OSoportes> findByNombreMedioIgnoreCase(String nombreMedio);
}
