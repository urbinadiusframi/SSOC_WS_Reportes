package co.gov.ssoc.gedess.sgd.model.entity.repository;	

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OCuadroClasificacionDocumental;
import co.gov.ssoc.gedess.sgd.model.entity.OSerie;

@Repository
public interface CuadroClasificacionDocumentalRepository extends JpaRepository<OCuadroClasificacionDocumental, Long>,
		JpaSpecificationExecutor<OCuadroClasificacionDocumental> {

	/*
	 * @Query(value =
	 * "SELECT DISTINCT t.codigoUnidadAdministrativa FROM OCuadroClasificacionDocumental t WHERE t.version = :version"
	 * ) List<Integer> searchDependenciasByVersion(Integer version);
	 * 
	 * @Query(value =
	 * "SELECT DISTINCT t.codigoOficinaProductora FROM OCuadroClasificacionDocumental t WHERE t.codigoUnidadAdministrativa  = :depen AND t.version = :version"
	 * ) List<Integer> searchOficinaProductoraByVersion(@Param("depen") Long
	 * depen,Integer version);
	 */

	@Query(value = "SELECT t FROM OCuadroClasificacionDocumental t WHERE t.version = :version ORDER BY t.nombreUnidadAdministrativa ASC")
	List<OCuadroClasificacionDocumental> searchCcdByVersion(@Param("version") Integer version);

	@Query(value = "SELECT t FROM OCuadroClasificacionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.version = :version")
	List<OCuadroClasificacionDocumental> searchOficinaProductoraByVersion(@Param("depen") Integer depen,
			@Param("version") Integer version);

	@Query(value = "SELECT DISTINCT t.serie FROM OCuadroClasificacionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.version = :version")
	List<OSerie> searchSeriesByVersion(@Param("depen") Integer depen, @Param("oficina") Integer oficina,
			@Param("version") Integer version);

	@Query(value = "SELECT DISTINCT t.serie, t.nombreActoAdministrativo,t.numeroActoAdministrativo,t.fechaActoAdministrativo,t.id FROM OCuadroClasificacionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.version = :version")
	List<Object[]> searchSeriesWithActoByVersion(@Param("depen") Integer depen, @Param("oficina") Integer oficina,
			@Param("version") Integer version);

	@Query(value = "SELECT DISTINCT t.subSerie FROM OCuadroClasificacionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.serie.id = :serie AND t.subSerie IS NOT NULL AND t.version = :version")
	List<OSerie> searchSubSeriesByVersion(@Param("depen") Integer depen, @Param("oficina") Integer oficina,
			@Param("serie") Long serie, @Param("version") Integer version);

	@Query(value = "SELECT DISTINCT t.subSerie, t.nombreActoAdministrativo,t.numeroActoAdministrativo,t.fechaActoAdministrativo,t.id FROM OCuadroClasificacionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.serie.id = :serie AND t.subSerie IS NOT NULL AND t.version = :version")
	List<Object[]> searchSubSeriesWithActoByVersion(@Param("depen") Integer depen, @Param("oficina") Integer oficina,
			@Param("serie") Long serie, @Param("version") Integer version);

	@Query(value = "SELECT t FROM OCuadroClasificacionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.serie.id = :serie")
	List<OCuadroClasificacionDocumental> searchInfoCcdWithSerie(@Param("depen") Integer depen,
			@Param("oficina") Integer oficina, @Param("serie") Long serie);

	@Query(value = "SELECT t FROM OCuadroClasificacionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina AND t.serie.id = :serie AND t.subSerie.id = :subSerie")
	List<OCuadroClasificacionDocumental> searchInfoCcdWithSubSerie(@Param("depen") Integer depen,
			@Param("oficina") Integer oficina, @Param("serie") Long serie, @Param("subSerie") Long subSerie);

	@Query(value = "SELECT MAX(t.version) FROM OCuadroClasificacionDocumental t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina")
	Integer searchVersionCcdByDependenciaAndOficina(@Param("depen") Integer depen, @Param("oficina") Integer oficina);

	@Query(value = "EXEC Administracion.SP_searchDynamicCCD   @nombreDependencia = :nombreDependencia, @codigoDependencia = :codigoDependencia , @nombreOficina = :nombreOficina , @codigoOficina = :codigoOficina , @nombreSerie = :nombreSerie , @codigoSerie = :codigoSerie, @nombreSubSerie = :nombreSubSerie, @codigoSubSerie = :codigoSubSerie ", nativeQuery = true)
	List<OCuadroClasificacionDocumental> spSearchDynamicCCD(String nombreDependencia, String codigoDependencia,
			String nombreOficina, String codigoOficina, String nombreSerie, String codigoSerie, String nombreSubSerie,
			String codigoSubSerie);

	@Query(value = "SELECT t FROM OCuadroClasificacionDocumental t WHERE t.codigoUnidadAdministrativa = :codigoUnidadAdministrativa"
			+ " and t.codigoOficinaProductora = :codigoOficinaProductora"
			+ " and t.serie.id = :serieId and t.subSerie is null "
			+ " and t.version = :version ORDER BY t.nombreUnidadAdministrativa ASC")
	List<OCuadroClasificacionDocumental> findExistente(
			@Param("codigoUnidadAdministrativa") Integer codigoUnidadAdministrativa,
			@Param("codigoOficinaProductora") Integer codigoOficinaProductora, @Param("serieId") Long serieId,
			@Param("version") Integer version);

	@Query(value = "SELECT MAX(version) FROM OCuadroClasificacionDocumental")
	Integer findLatestVersion();

}
