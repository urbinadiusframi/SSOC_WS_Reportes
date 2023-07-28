package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OSerie;

@Repository
public interface SerieRepository
		extends JpaRepository<OSerie, Long>, JpaSpecificationExecutor<OSerie>
//, org.springframework.data.repository.history.RevisionRepository<OSerie, Long, Long> 
{

	Optional<OSerie> findByNombre(String nombre);

	@Query(value = "SELECT s FROM OSerie s WHERE (codigo = :codigo) AND s.seriePadre is null ")
	Optional<OSerie> findSerieByCodigo(@Param("codigo") Integer codigo);

	Optional<OSerie> findByCodigo(Integer codigo);

	Optional<OSerie> findByCodigoAndNombreIgnoreCaseAndSeriePadre(Integer codigo, String nombre, Long seriePadre);

	Optional<OSerie> findByCodigoAndNombreIgnoreCase(Integer codigo, String nombre);

	List<OSerie> findByCodigoOrNombreIgnoreCase(Integer codigo, String nombre);

	Optional<OSerie> findByCodigoAndNombreAndEstado(Integer codigo, String nombre, Boolean estado);

	@Query(value = "SELECT s FROM OSerie s WHERE (codigo = :codigo) AND s.seriePadre is null AND s.estado = :estado ")
	Optional<OSerie> findSerieByCodigoAndEstado(@Param("codigo") Integer codigo, @Param("estado") Boolean estado);

	@Query(value = "SELECT s FROM OSerie s WHERE (codigo = :codigo OR lower(s.nombre) = lower(:nombre)) AND s.estado = :estado ORDER BY s.nombre")
	List<OSerie> findByCodigoOrNombreIgnoreCaseAndEstado(@Param("codigo") Integer codigo, @Param("nombre") String nombre, @Param("estado") Boolean estado);

	@Query(value = "SELECT s FROM OSerie s WHERE (codigo = :codigo AND lower(s.nombre) = lower(:nombre)) AND s.seriePadre = (SELECT sp.id FROM OSerie sp WHERE (sp.codigo = :padre) AND sp.seriePadre is null) AND s.estado = :estado ORDER BY s.nombre")
	Optional<OSerie> findByCodigoAndNombreIgnoreCaseAndPadreAndEstado(@Param("codigo") Integer codigo, @Param("nombre") String nombre, @Param("padre") Integer padre,
			@Param("estado") Boolean estado);

	@Query(value = "SELECT s FROM OSerie s WHERE (codigo = :codigo) AND s.seriePadre = (SELECT sp.id FROM OSerie sp WHERE (sp.codigo = :padre) AND sp.seriePadre is null) AND s.estado = :estado ORDER BY s.nombre")
	Optional<OSerie> findByCodigoAndPadreAndEstado(@Param("codigo") Integer codigo, @Param("padre") Integer padre, @Param("estado") Boolean estado);

	@Query(value = "SELECT s FROM OSerie s WHERE s.seriePadre IS NOT NULL Order by s.nombre") // AND s.estado = 1
	List<OSerie> searchOnlySubSeries();

	@Query(value = "SELECT s FROM OSerie s WHERE s.seriePadre IS NULL  Order by s.nombre") // AND s.estado = 1
	List<OSerie> searchOnlySeries();

	@Query(value = "SELECT s FROM OSerie s WHERE (codigo = :codigo) AND s.seriePadre = (SELECT sp.id FROM OSerie sp WHERE (sp.codigo = :padre) AND sp.seriePadre is null) ORDER BY s.nombre")
	Optional<OSerie> findByCodigoAndPadre(@Param("codigo") Integer codigo, @Param("padre") Integer padre);

//	@Query(value = "SELECT s FROM OSerie s WHERE s.seriePadre = :idSeriePadre AND s.estado = 1 Order by s.nombre")
	List<OSerie> searchSubSeriesBySeriePadreAndEstadoOrderByNombre(Long seriePadre, Boolean estado);

	@Query(value = "EXEC Administracion.SP_searchDynamicSeries  @nombreSerie = :nombreSerie , @codigoSerie = :codigoSerie , @nombreMotivo = :nombreMotivo , @nombreCuaderno = :nombreCuaderno , @actoAdministrativo = :actoAdministrativo , @estado = :estado , @tipo = :tipo ", nativeQuery = true)
	List<OSerie> spSearchDynamicSeries(@Param("nombreSerie") String nombreSerie,
			@Param("codigoSerie") Integer codigoSerie, @Param("nombreMotivo") String nombreMotivo,
			@Param("nombreCuaderno") String nombreCuaderno, @Param("actoAdministrativo") String actoAdministrativo,
			@Param("estado") Integer estado, @Param("tipo") Integer tipo);

	@Query(value = "EXEC Administracion.SP_searchDynamicSubSeries  @nombreSerie = :nombreSerie , @codigoSerie = :codigoSerie , @nombreSubSerie = :nombreSubSerie , @codigoSubSerie = :codigoSubSerie , @nombreMotivo = :nombreMotivo , @nombreCuaderno = :nombreCuaderno , @actoAdministrativo = :actoAdministrativo , @estado = :estado , @tipo = :tipo ", nativeQuery = true)
	List<OSerie> spSearchDynamicSubSeries(@Param("nombreSerie") String nombreSerie,
			@Param("codigoSerie") Integer codigoSerie, @Param("nombreSubSerie") String nombreSubSerie,
			@Param("codigoSubSerie") Integer codigoSubSerie, @Param("nombreMotivo") String nombreMotivo,
			@Param("nombreCuaderno") String nombreCuaderno, @Param("actoAdministrativo") String actoAdministrativo,
			@Param("estado") Integer estado, @Param("tipo") Integer tipo);

	@Query(value = "SELECT s.codigo,s.nombre,t.Codigo,t.Nombre  FROM Administracion.Series s LEFT JOIN Administracion.SerieTipoSerie sts on s.id = sts.IdSerie  LEFT JOIN Administracion.TipoSerie t ON t.Id = sts.IdTipoSerie WHERE s.serie_padre IS NULL Order by s.nombre", nativeQuery = true)
	List<Object[]> searchOnlySeriesWithType();

	Optional<OSerie> findByCodigoAndSeriePadreAndEstado(Integer codigo, Long idPadre, Boolean estado);

	@Query(value = " SELECT s.codigo codigoSerie,s.nombre nombreSerie,t.Codigo codigoTipo,t.Nombre nombreTipo, "
			+ " ( SELECT papa.codigo FROM Administracion.Series papa  where papa.id = s.serie_padre) codigoPadre, "
			+ " ( SELECT papa.nombre FROM Administracion.Series papa  where papa.id = s.serie_padre) nombrePadre "
			+ " FROM Administracion.Series s LEFT JOIN Administracion.SerieTipoSerie sts on s.id = sts.IdSerie  LEFT JOIN Administracion.TipoSerie t ON t.Id = sts.IdTipoSerie WHERE s.Id IN (SELECT IdSerie FROM Administracion.TramiteSeries WHERE IdTramite = :tramite) Order by s.nombre", nativeQuery = true)
	List<Object[]> searchSeriesByTramite(@Param("tramite") Long tramite);
}