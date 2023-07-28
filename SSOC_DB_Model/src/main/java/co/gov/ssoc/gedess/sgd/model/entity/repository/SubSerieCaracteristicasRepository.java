package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OSerie;
import co.gov.ssoc.gedess.sgd.model.entity.OSeriesCaracteristicas;
import co.gov.ssoc.gedess.sgd.model.entity.OSubSerie;
import co.gov.ssoc.gedess.sgd.model.entity.OSubSeriesCaracteristicas;

@Repository
public interface SubSerieCaracteristicasRepository extends JpaRepository<OSubSeriesCaracteristicas, Long> //, org.springframework.data.repository.history.RevisionRepository<OSubSeriesCaracteristicas, Long , Long>
{

	@Query(value = "SELECT sc.serieCaracteristicaPK.caracteristica.nombre FROM OSubSeriesCaracteristicas sc WHERE sc.serieCaracteristicaPK.subserie = :subserie")
	List<String> searchCaracteristicasBySerie(@Param("subserie") OSubSerie subserie);	
}