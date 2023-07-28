package co.gov.ssoc.gedess.sgd.model.entity.repository;	

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OEstadoRadicacion;
import co.gov.ssoc.gedess.sgd.model.entity.OEstadosTransicionRadicacion;

@Repository
public interface EstadosTransicionRadicacionRepository extends JpaRepository<OEstadosTransicionRadicacion, Long> {

	Optional<OEstadosTransicionRadicacion> findByEstadoRadicacion(OEstadoRadicacion nombreEstado);
}