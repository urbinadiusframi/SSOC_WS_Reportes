package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OSerie;
import co.gov.ssoc.gedess.sgd.model.entity.OSeriesCaracteristicas;

@Repository
public interface SerieCaracteristicasRepository extends JpaRepository<OSeriesCaracteristicas, Long> //, org.springframework.data.repository.history.RevisionRepository<OSeriesCaracteristicas, Long , Long>
{

	@Query(value = "SELECT sc.serieCaracteristicaPK.caracteristica.nombre FROM OSeriesCaracteristicas sc WHERE sc.serieCaracteristicaPK.serie = :serie")
	List<String> searchCaracteristicasBySerie(@Param("serie") OSerie serie);	
}