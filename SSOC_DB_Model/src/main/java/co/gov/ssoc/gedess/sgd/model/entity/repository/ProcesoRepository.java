package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OProceso;

@Repository
public interface ProcesoRepository extends JpaRepository<OProceso, Long>
//, org.springframework.data.repository.history.RevisionRepository<OProceso, Long, Long>>
{

	List<OProceso> findAllByCodigoInOrderByCodigoAsc(List<Integer> codigos);

	Optional<OProceso> findByCodigoAndNombreIgnoreCase(Integer codigo, String nombre);

	Optional<OProceso> findByCodigo(Integer codigo);

	Optional<OProceso> findByNombreIgnoreCase(String nombre);

	Optional<OProceso> findByCodigoAndEstado(Integer codigo, Boolean estado);

	@Query("SELECT o FROM OProceso o WHERE (LOWER(STR(o.codigo)) like LOWER(CONCAT('%', :codigo,'%'))) ORDER BY o.codigo ASC ")
	List<OProceso> findByCodigoLikeIgnoreCase(@Param("codigo") String codigo);

	@Query("SELECT o FROM OProceso o WHERE (LOWER(STR(o.codigo)) like LOWER(CONCAT('%', :codigo,'%'))) AND o.estado = :estado ORDER BY o.codigo ASC")
	List<OProceso> findByCodigoAndEstado(@Param("codigo") String codigo, @Param("estado") Boolean estado);

	@Query("SELECT o FROM OProceso o WHERE (LOWER(o.nombre) LIKE LOWER(CONCAT('%', :nombre,'%'))) ORDER BY o.codigo ASC ")
	List<OProceso> findByNombreLikeIgnoreCase(@Param("nombre") String nombre);

	@Query("SELECT o FROM OProceso o WHERE (LOWER(o.nombre) LIKE LOWER(CONCAT('%', :nombre,'%'))) AND o.estado = :estado ORDER BY o.codigo ASC")
	List<OProceso> findByNombreLikeIgnoreCaseAndEstado(@Param("nombre") String nombre, @Param("estado") Boolean estado);

	@Query("SELECT o FROM OProceso o WHERE (LOWER(STR(o.codigo)) like LOWER(CONCAT('%', :codigo,'%')) OR LOWER(o.nombre) LIKE LOWER(CONCAT('%', :nombre,'%'))) ORDER BY o.codigo ASC ")
	List<OProceso> findByCodigoOrNombreLikeIgnoreCase(@Param("codigo") String codigo, @Param("nombre") String nombre);

	@Query("SELECT o FROM OProceso o WHERE (LOWER(STR(o.codigo)) like LOWER(CONCAT('%', :codigo,'%')) OR LOWER(o.nombre) LIKE LOWER(CONCAT('%', :nombre,'%'))) AND o.estado = :estado ORDER BY o.codigo ASC")
	List<OProceso> findByCodigoOrNombreLikeIgnoreCaseAndEstado(@Param("codigo") String codigo,
			@Param("nombre") String nombre, @Param("estado") Boolean estado);
}