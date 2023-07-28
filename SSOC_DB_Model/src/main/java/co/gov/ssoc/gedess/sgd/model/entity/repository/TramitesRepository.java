package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTramite;

@Repository
public interface TramitesRepository extends JpaRepository<OTramite, Long>, JpaSpecificationExecutor<OTramite>
//,org.springframework.data.repository.history.RevisionRepository<OTramite, Long, Long> 
{

	Optional<List<OTramite>> findByEstadoOrderByNombreAsc(Boolean estado);

	List<OTramite> findByCodigo(Integer codigo);

	Optional<OTramite> findByCodigoAndEstado(Integer codigo, Boolean estado);

	Optional<OTramite> findByNombreAndEstado(String nombre, Boolean estado);

	List<OTramite> findByNombreIgnoreCase(String nombre);

	List<OTramite> findByCodigoIn(List<Integer> list);

	@Query("SELECT o FROM OTramite o WHERE (LOWER(CONCAT('',o.codigo,'')) like LOWER(CONCAT('', :codigo,''))) ")
	List<OTramite> findByCodigoLikeIgnoreCase(String codigo);

	@Query("SELECT o FROM OTramite o WHERE (LOWER(CONCAT('',o.codigo,'')) like LOWER(CONCAT('', :codigo,''))) AND o.estado = :estado")
	List<OTramite> findByCodigoAndEstado(String codigo, Boolean estado);

	@Query("SELECT o FROM OTramite o WHERE (LOWER(o.nombre) LIKE LOWER(CONCAT('', :nombre,''))) ")
	List<OTramite> findByNombreLikeIgnoreCase(String nombre);

	@Query("SELECT o FROM OTramite o WHERE (LOWER(o.nombre) LIKE LOWER(CONCAT('%', :nombre,'%'))) AND o.estado = :estado")
	List<OTramite> findByNombreLikeIgnoreCaseAndEstado(String nombre, Boolean estado);

	@Query("SELECT o FROM OTramite o WHERE (LOWER(CONCAT('',o.codigo,'')) like LOWER(CONCAT('', :codigo,'')) OR LOWER(o.nombre) LIKE LOWER(CONCAT('', :nombre,''))) ")
	List<OTramite> findByCodigoOrNombreLikeIgnoreCase(String codigo, String nombre);

	@Query("SELECT o FROM OTramite o WHERE (LOWER(CONCAT('',o.codigo,'')) like LOWER(CONCAT('', :codigo,'')) OR LOWER(o.nombre) LIKE LOWER(CONCAT('', :nombre,''))) AND o.estado = :estado")
	List<OTramite> findByCodigoOrNombreLikeIgnoreCaseAndEstado(String codigo, String nombre, Boolean estado);

//	@Query("UPDATE TramiteRelaciones SET ESTADO = :estado WHERE  ")
//	List<OTramiteRelaciones> findByCodigoLikeIgnoreCase(String codigo);

}