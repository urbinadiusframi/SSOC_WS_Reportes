package co.gov.ssoc.gedess.sgd.model.entity.repository;	

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OEstadoRadicacion;

@Repository
public interface EstadoRadicacionRepository extends JpaRepository<OEstadoRadicacion, Long> {

	Optional<OEstadoRadicacion> findByNombreIgnoreCase(String nombre);
	List<OEstadoRadicacion> findByNombreIgnoreCaseIn(List<String> estados); 
}