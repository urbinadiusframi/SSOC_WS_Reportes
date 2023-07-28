package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OPlantillaFilenet;
import co.gov.ssoc.gedess.sgd.model.entity.OTramite;

@Repository
public interface PlantillasFilenetRepository extends JpaRepository<OPlantillaFilenet, Long> {

	Optional<List<OPlantillaFilenet>> findByTramite(OTramite tramite);

	Optional<List<OPlantillaFilenet>> findByTramiteIn(List<OTramite> tramite);

}