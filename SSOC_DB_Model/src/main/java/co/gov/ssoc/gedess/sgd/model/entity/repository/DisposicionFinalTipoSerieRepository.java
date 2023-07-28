package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.ODisposicionFinalTipoSerie;

@Repository
public interface DisposicionFinalTipoSerieRepository extends JpaRepository<ODisposicionFinalTipoSerie, Long>
//, org.springframework.data.repository.history.RevisionRepository<ODisposicionFinalTipoSerie, Long, Long>>
{

	@Query(value = "select s.*,d.Codigo, d.Nombre from [Administracion].[SerieDisposicionFinal] s "
			+ "LEFT JOIN [Administracion].[DisposicionFinalSerie] dfs ON s.Id = dfs.IdDisposicionFinalSerie "
			+ "LEFT JOIN [Administracion].[DisposicionFinal] d ON d.Id = dfs.IdDisposicionFinal", nativeQuery = true)
	List<Object[]> searchAllDisposicionFinalSerie();

//	@Query(value = "SELECT d.nombre FROM [Administracion].[DisposicionFinal] d "
//			+ " LEFT JOIN [Administracion].[DisposicionFinalSerie] dfs ON d.Id = dfs.IdDisposicionFinal "
//			+ " LEFT JOIN [Administracion].[SerieDisposicionFinal] s ON s.Id = dfs.IdDisposicionFinalSerie "
//			+ " WHERE s.Id = :serieDisposicionFinal", nativeQuery = true)
//	List<String> searchAllDisposicionFinalSerie(@Param("serieDisposicionFinal") Long serieDisposicionFinal);

	@Query(value = "select d from ODisposicionFinalTipoSerie d WHERE d.disposicionFinalSerie.id = :disposicionId ")
	List<ODisposicionFinalTipoSerie> searchAllDisposicionFinalSerieBySerie(@Param("disposicionId") Long disposicionId);

	@Query(value = "select d from ODisposicionFinalTipoSerie d WHERE d.disposionFinal.id = :tipoId AND d.disposicionFinalSerie.id = :disposicionId ")
	List<ODisposicionFinalTipoSerie> searchAllDisposicionFinalSerie(@Param("tipoId") Long tipoId,
			@Param("disposicionId") Long disposicionId);

}