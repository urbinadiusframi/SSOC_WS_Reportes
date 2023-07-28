package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OCaracteristicas;

@Repository
public interface CaracteristicasRepository extends JpaRepository<OCaracteristicas, Long> //, org.springframework.data.repository.history.RevisionRepository<OCaracteristicas, Long , Long> 
{

	Optional<OCaracteristicas> findByNombre(String nombre);
	List<OCaracteristicas> findByNombreIgnoreCaseIn(List<String> nombre);

}