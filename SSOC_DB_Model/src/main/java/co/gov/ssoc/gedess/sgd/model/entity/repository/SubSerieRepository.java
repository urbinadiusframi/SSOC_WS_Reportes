package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OSubSerie;

@Repository
public interface SubSerieRepository extends JpaRepository<OSubSerie, Long>, JpaSpecificationExecutor<OSubSerie>
//, org.springframework.data.repository.history.RevisionRepository<OSubSerie, Long, Long>>
{

	Optional<OSubSerie> findByNombre(String nombre);

	@Query(value = "SELECT s FROM OSubSerie s WHERE (codigo = :codigo) AND s.seriePadre is null ")
	Optional<OSubSerie> findSerieByCodigo(@Param("codigo") BigInteger codigo);

	Optional<OSubSerie> findByCodigo(BigInteger codigo);

	Optional<OSubSerie> findByCodigoAndSeriePadre(BigInteger codigo, Long seriePadre);

	Optional<OSubSerie> findByCodigoAndNombreIgnoreCaseAndSeriePadre(BigInteger codigo, String nombre, Long seriePadre);
	
	Optional<OSubSerie> findByCodigoAndNombreIgnoreCaseAndSeriePadreAndEstado(BigInteger codigo, String nombre, Long seriePadre, Boolean estado);

	Optional<OSubSerie> findByCodigoAndNombreIgnoreCase(BigInteger codigo, String nombre);

	Optional<OSubSerie> findByCodigoAndNombreAndEstado(BigInteger codigo, String nombre, Boolean estado);

	@Query(value = "SELECT s FROM OSubSerie s WHERE (codigo = :codigo) AND s.seriePadre is null AND s.estado = :estado ")
	Optional<OSubSerie> findSerieByCodigoAndEstado(@Param("codigo") BigInteger codigo, @Param("estado") Boolean estado);

	@Query(value = "SELECT s FROM OSubSerie s WHERE (codigo = :codigo OR lower(s.nombre) = lower(:nombre)) AND s.estado = :estado ORDER BY s.nombre")
	List<OSubSerie> findByCodigoOrNombreIgnoreCaseAndEstado(@Param("codigo") BigInteger codigo,
			@Param("nombre") String nombre, @Param("estado") Boolean estado);

	@Query(value = "SELECT s FROM OSubSerie s WHERE (codigo = :codigo AND lower(s.nombre) = lower(:nombre)) AND s.seriePadre = (SELECT sp.id FROM OSerie sp WHERE (sp.codigo = :padre) AND sp.seriePadre is null) AND s.estado = :estado ORDER BY s.nombre")
	Optional<OSubSerie> findByCodigoAndNombreIgnoreCaseAndPadreAndEstado(@Param("codigo") BigInteger codigo,
			@Param("nombre") String nombre, @Param("padre") Integer padre, @Param("estado") Boolean estado);

	@Query(value = "SELECT s FROM OSubSerie s WHERE (codigo = :codigo) AND s.seriePadre = (SELECT sp.id FROM OSerie sp WHERE (sp.codigo = :padre) AND sp.seriePadre is null) AND s.estado = :estado ORDER BY s.nombre")
	Optional<OSubSerie> findByCodigoAndPadreAndEstado(@Param("codigo") BigInteger codigo, @Param("padre") Integer padre,
			@Param("estado") Boolean estado);

	@Query(value = "SELECT s FROM OSubSerie s WHERE s.seriePadre IS NOT NULL Order by s.nombre") // AND s.estado = 1
	List<OSubSerie> searchOnlySubSeries();

	@Query(value = "SELECT s FROM OSubSerie s WHERE s.seriePadre IS NULL  Order by s.nombre") // AND s.estado = 1
	List<OSubSerie> searchOnlySeries();

	// TODO: Revisar masivo de CCD
	@Query(value = "SELECT s FROM OSubSerie s WHERE (codigo = :codigo) AND s.seriePadre = (SELECT sp.id FROM OSerie sp WHERE (sp.codigo = :padre) AND sp.seriePadre is null) ORDER BY s.nombre")
	Optional<OSubSerie> findByCodigoAndPadre(@Param("codigo") BigInteger codigo, @Param("padre") Integer padre);

	@Query(value = "SELECT s FROM OSubSerie s WHERE (codigo = :codigo) AND s.nombre = :nombre AND s.seriePadre = (SELECT sp.id FROM OSerie sp WHERE (sp.codigo = :padre) AND sp.seriePadre is null) ORDER BY s.nombre")
	Optional<OSubSerie> findByCodigoAndNombreAndPadre(@Param("codigo") BigInteger codigo,
			@Param("nombre") String nombre, @Param("padre") Integer padre);

	@Query(value = "SELECT s FROM OSubSerie s WHERE s.seriePadre = :seriePadre AND s.estado = :estado Order by s.nombre")
	List<OSubSerie> searchSubSeriesBySeriePadreAndEstadoOrderByNombre(@Param("seriePadre") Long seriePadre,
			@Param("estado") Boolean estado);

	@Query(value = "EXEC Administracion.SP_searchDynamicSeries  @nombreSerie = :nombreSerie , @codigoSubSerie = :codigoSubSerie , @nombreMotivo = :nombreMotivo , @nombreCuaderno = :nombreCuaderno , @actoAdministrativo = :actoAdministrativo , @estado = :estado , @tipo = :tipo ", nativeQuery = true)
	List<OSubSerie> spSearchDynamicSeries(@Param("nombreSerie") String nombreSerie,
			@Param("codigoSubSerie") Integer codigoSubSerie, @Param("nombreMotivo") String nombreMotivo,
			@Param("nombreCuaderno") String nombreCuaderno, @Param("actoAdministrativo") String actoAdministrativo,
			@Param("estado") Integer estado, @Param("tipo") Integer tipo);

	@Query(value = "EXEC Administracion.SP_searchDynamicSubSeries  @nombreSerie = :nombreSerie , @codigoSerie = :codigoSerie , @nombreSubSerie = :nombreSubSerie , @codigoSubSerie = :codigoSubSerie , @nombreMotivo = :nombreMotivo , @nombreCuaderno = :nombreCuaderno , @actoAdministrativo = :actoAdministrativo , @estado = :estado , @tipo = :tipo ", nativeQuery = true)
	List<OSubSerie> spSearchDynamicSubSeries(@Param("nombreSerie") String nombreSerie,
			@Param("codigoSerie") Integer codigoSerie, @Param("nombreSubSerie") String nombreSubSerie,
			@Param("codigoSubSerie") Integer codigoSubSerie, @Param("nombreMotivo") String nombreMotivo,
			@Param("nombreCuaderno") String nombreCuaderno, @Param("actoAdministrativo") String actoAdministrativo,
			@Param("estado") Integer estado, @Param("tipo") Integer tipo);

	@Query(value = "SELECT s.codigo,s.nombre,t.Codigo,t.Nombre  FROM Administracion.Series s LEFT JOIN Administracion.SerieTipoSubSerie sts on s.id = sts.IdSerie  LEFT JOIN Administracion.TipoSubSerie t ON t.Id = sts.IdTipoSubSerie WHERE s.serie_padre IS NULL Order by s.nombre", nativeQuery = true)
	List<Object[]> searchOnlySeriesWithType();

	Optional<OSubSerie> findByCodigoAndSeriePadreAndEstado(BigInteger codigo, Long idPadre, Boolean estado);

	@Query(value = " SELECT s.codigo codigoSubSerie,s.nombre nombreSerie,"
			+ " ( SELECT papa.codigo FROM Administracion.Series papa  where papa.id = s.serie_padre) codigoPadre, "
			+ " ( SELECT papa.nombre FROM Administracion.Series papa  where papa.id = s.serie_padre) nombrePadre "
			+ " FROM Administracion.SubSeries s WHERE s.Id IN (SELECT IdSubSerie FROM Administracion.TramiteSubSeries WHERE IdTramite = :tramite) Order by s.nombre", nativeQuery = true)
	List<Object[]> searchSubSeriesByTramite(Long tramite);
}