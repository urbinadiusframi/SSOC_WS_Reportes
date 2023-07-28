package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumental;

@Repository
public interface TipoDocumentalRepository
		extends JpaRepository<OTipoDocumental, Long>, JpaSpecificationExecutor<OTipoDocumental>
//, org.springframework.data.repository.history.RevisionRepository<OTipoDocumental, Long, Long>>
{

	@Procedure("OTipoDocumental.getConsecutiveByTipoDocumental")
	String getConsecutiveByTipoDocumental(@Param("pCodigo") String codigo);

	Optional<List<OTipoDocumental>> findByEstadoOrderByNombreAsc(Boolean estado);

	List<OTipoDocumental> findByNombreContainingIgnoreCaseAndEstado(String codigo, Boolean estado);

	Optional<OTipoDocumental> findByNombre(String codigo);

	List<OTipoDocumental> findAllByNombre(String codigo);

	List<OTipoDocumental> findAllByNombreIgnoreCase(String nombre);

	List<OTipoDocumental> findAllByIdOrNombre(Long id, String nombre);

	List<OTipoDocumental> findAllByIdOrNombreIgnoreCase(Long id, String nombre);

	Optional<OTipoDocumental> findByCodigo(String codigo);

	@Query(value = "SELECT s FROM OTipoDocumental s WHERE nombre = :nombre")
	Optional<OTipoDocumental> findOneByNombre(String nombre);

	@Query(value = "SELECT s FROM OTipoDocumental s WHERE (LOWER(nombre) LIKE LOWER(CONCAT('%', :nombre,'%')))")
	OTipoDocumental NombreContainig(String nombre);

	@Query(value = "SELECT s FROM OTipoDocumental s WHERE (LOWER(nombre) LIKE LOWER(CONCAT('%', :nombre,'%'))) and estado = :estado")
	OTipoDocumental findByNombreContainigAndEstado(String nombre, Boolean estado);

	@Query(value = "SELECT s FROM OTipoDocumental s WHERE (LOWER(nombre) in :nombre)")
	List<OTipoDocumental> findByCodigoIgnoreCaseInOrderByNombreAsc(List<String> nombre);

	Optional<OTipoDocumental> findByNombreIgnoreCase(String nombre);

	List<OTipoDocumental> findByNombreIgnoreCaseInOrderByNombreAsc(String[] tiposDocumentales);

	List<OTipoDocumental> findByNombreIgnoreCaseInOrderByNombreAsc(List<String> tiposDocumentales);

	@Query(value = "SELECT NEXT VALUE FOR correspondencia.sqc_tipo_documental", nativeQuery = true)
	Integer getNextValSequenceTipoDocumental();

	@Query(value = "EXEC Administracion.SP_searchDynamicTipoDocumental  @nombre = :nombre , @estado = :estado ", nativeQuery = true)
	List<OTipoDocumental> spSearchDynamicTipoDocumental(@Param("nombre") String nombre,
			@Param("estado") Integer estado);

	@Query(value = "DECLARE @retval INT " + "EXEC @retval = Administracion.SiguienteCodigoTipoDocumental "
			+ " SELECT @retval ", nativeQuery = true)
	BigInteger spSiguienteCodigoTipoDocumental();



	OTipoDocumental findByCodigoIgnoreCase(String codigo);
	List<OTipoDocumental> findByCodigoIgnoreCaseIn(List<String> codigo);
	
	Optional<OTipoDocumental> findByCodigoIgnoreCaseOrNombreIgnoreCase(String codigo,String nombre);
	List<OTipoDocumental> findByCodigoIgnoreCaseIn(String[] codigo);
	List<OTipoDocumental> findByNombreIgnoreCaseIn(String[] tiposDocumentales); 
}
