package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OSerieRelaTipoSerie;

@Repository
public interface SerieTipoSerieRepository extends JpaRepository<OSerieRelaTipoSerie, Long> //, org.springframework.data.repository.history.RevisionRepository<OSerieRelaTipoSerie, Long , Long>
{

	@Query(value = "SELECT t.Codigo,t.Nombre  FROM Administracion.TipoSerie t LEFT JOIN Administracion.SerieTipoSerie sts ON t.Id = sts.IdTipoSerie LEFT JOIN Administracion.Series s ON s.Id = sts.IdSerie WHERE s.Codigo = :padre Order by t.Nombre", nativeQuery = true)
	List<Object[]> searchOnlySeriesWithType(@Param("padre") Integer padre);
}