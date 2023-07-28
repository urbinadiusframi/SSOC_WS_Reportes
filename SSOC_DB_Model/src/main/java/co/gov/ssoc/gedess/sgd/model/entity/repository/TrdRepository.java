package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OSerie;
import co.gov.ssoc.gedess.sgd.model.entity.OSubSerie;
import co.gov.ssoc.gedess.sgd.model.entity.OTablaRetencionDocumental;

@Repository
public interface TrdRepository
		extends JpaRepository<OTablaRetencionDocumental, Long>, JpaSpecificationExecutor<OTablaRetencionDocumental>
//, org.springframework.data.repository.history.RevisionRepository<OTablaRetencionDocumental, Long, Long>>
{

	/*
	 * @Query(value =
	 * "SELECT DISTINCT t.dependencia FROM OTablaRetencionDocumental t")
	 * List<Integer> searchDependencias();
	 * 
	 * @Query(value =
	 * "SELECT DISTINCT t.dependencia FROM OTablaRetencionDocumental t WHERE t.version = :version"
	 * ) List<Integer> searchDependenciasByVersion(Integer version);
	 * 
	 * @Query(value =
	 * "SELECT DISTINCT t.oficinaProductora FROM OTablaRetencionDocumental t WHERE t.dependencia.id = :depen"
	 * ) List<Integer> searchOficinaProductora(@Param("depen") Long depen);
	 */
	@Query(value = "SELECT t FROM OTablaRetencionDocumental t WHERE t.version = :version")
	List<OTablaRetencionDocumental> searchTrdByVersion(@Param("version") Integer version);

	@Query(value = "SELECT t FROM OTablaRetencionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.version = :version")
	List<OTablaRetencionDocumental> searchOficinaProductoraByVersion(@Param("depen") Integer depen,
			@Param("version") Integer version);

	@Query(value = "SELECT DISTINCT t.serie FROM OTablaRetencionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.subSerie IS NULL")
	List<OSerie> searchSeries(@Param("depen") Integer depen, @Param("oficina") Long oficina);

	@Query(value = "SELECT DISTINCT t.serie FROM OTablaRetencionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina  AND t.version = :version ORDER BY t.serie.codigo") // TODO
																																																						// se
																																																						// suprimer
																																																						// para
																																																						// obtener
																																																						// las
																																																						// SubSeries
																																																						// AND
																																																						// t.subSerie
																																																						// IS
																																																						// NULL
	List<OSerie> searchSeriesByVersion(@Param("depen") Integer depen, @Param("oficina") Integer oficina,
			@Param("version") Integer version);

	@Query(value = "SELECT DISTINCT t.subSerie FROM OTablaRetencionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.serie.id = :serie AND t.subSerie IS NOT NULL")
	List<OSerie> searchSubSeries(@Param("depen") Integer depen, @Param("oficina") Integer oficina,
			@Param("serie") Long serie);

	@Query(value = "SELECT DISTINCT t.subSerie FROM OTablaRetencionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.serie.id = :serie AND t.subSerie IS NOT NULL AND t.version = :version")
	List<OSubSerie> searchSubSeriesByVersion(@Param("depen") Integer depen, @Param("oficina") Integer oficina,
			@Param("serie") Long serie, @Param("version") Integer version);

	@Query(value = "SELECT t FROM OTablaRetencionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.serie.id = :serie AND t.subSerie.id = NULL")
	List<OTablaRetencionDocumental> searchInfoTrdWithSerie(@Param("depen") Integer depen,
			@Param("oficina") Integer oficina, @Param("serie") Long serie);

	@Query(value = "SELECT t FROM OTablaRetencionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.serie.id = :serie AND t.version = :version")
	List<OTablaRetencionDocumental> searchInfoTrdWithSerieByVersion(@Param("depen") Integer depen,
			@Param("oficina") Integer oficina, @Param("serie") Long serie, @Param("version") Integer version);

	@Query(value = "SELECT t FROM OTablaRetencionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.serie.id = :serie AND t.subSerie.id = :subSerie")
	List<OTablaRetencionDocumental> searchInfoTrdWithSubSerie(@Param("depen") Integer depen,
			@Param("oficina") Integer oficina, @Param("serie") Long serie, @Param("subSerie") Long subSerie);

	@Query(value = "SELECT t FROM OTablaRetencionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.serie.id = :serie AND t.subSerie.id = :subSerie AND t.version = :version")
	List<OTablaRetencionDocumental> searchInfoTrdWithSubSerieByVersion(@Param("depen") Integer depen,
			@Param("oficina") Integer oficina, @Param("serie") Long serie, @Param("subSerie") Long subSerie,
			@Param("version") Integer version);

	@Query(value = "SELECT MAX(t.version) FROM OTablaRetencionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina")
	Integer searchVersionTrdByDependenciaAndOficina(@Param("depen") Integer depen, @Param("oficina") Integer oficina);

	@Query(value = "EXEC Administracion.SP_searchDynamicTRD   @nombreDependencia = :nombreDependencia, @codigoDependencia = :codigoDependencia , @nombreOficina = :nombreOficina , @codigoOficina = :codigoOficina , @nombreSerie = :nombreSerie , @codigoSerie = :codigoSerie, @nombreSubSerie = :nombreSubSerie, @codigoSubSerie = :codigoSubSerie , @tipoDocumental = :tipoDocumental , @soporte = :soporte , @tiempoRetencionCentral = :tiempoRetencionCentral , @tiempoRetencionGestion = :tiempoRetencionGestion , @disposicionFinal = :disposicionFinal , @procedimiento = :procedimiento", nativeQuery = true)
	List<OTablaRetencionDocumental> spSearchDynamicTRD(String nombreDependencia, String codigoDependencia,
			String nombreOficina, String codigoOficina, String nombreSerie, String codigoSerie, String nombreSubSerie,
			String codigoSubSerie, String tipoDocumental, String soporte, String tiempoRetencionCentral,
			String tiempoRetencionGestion, String disposicionFinal, String procedimiento);

	@Query(value = "SELECT MAX(version) FROM OTablaRetencionDocumental")
	Integer findLatestVersion();

}
