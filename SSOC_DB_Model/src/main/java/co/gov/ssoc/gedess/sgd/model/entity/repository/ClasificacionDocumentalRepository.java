package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OClasificacionDocumental;
import co.gov.ssoc.gedess.sgd.model.entity.ORadicacion;

@Repository
public interface ClasificacionDocumentalRepository extends JpaRepository<OClasificacionDocumental, Long> {
	
	Optional<OClasificacionDocumental> findByRadicado(ORadicacion radicado);	
}