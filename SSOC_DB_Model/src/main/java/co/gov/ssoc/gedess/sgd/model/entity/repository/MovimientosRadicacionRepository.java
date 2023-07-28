package co.gov.ssoc.gedess.sgd.model.entity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OMovimientosRadicacion;
import co.gov.ssoc.gedess.sgd.model.entity.ORadicacion;

@Repository
public interface MovimientosRadicacionRepository extends JpaRepository<OMovimientosRadicacion, Long> {

	Page<OMovimientosRadicacion> findByRadicacion(ORadicacion radicacion,Pageable pageable);
}