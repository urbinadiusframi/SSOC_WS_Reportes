package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTipoCuaderno;

@Repository
public interface TipoCuadernoRepository extends JpaRepository<OTipoCuaderno, Long> //, org.springframework.data.repository.history.RevisionRepository<OTipoCuaderno, Long , Long>
{

	Optional<OTipoCuaderno> findByCodigo(Integer codigo);

	Optional<OTipoCuaderno> findByCodigoOrNombreIgnoreCase(Integer codigo, String nombre);

	Optional<OTipoCuaderno> findByNombreIgnoreCase(String nombre);

	List<OTipoCuaderno> findByCodigoOrderByCodigoAsc(Integer nombre);

	@Query("SELECT o FROM OTipoCuaderno o WHERE (LOWER(o.nombre) LIKE LOWER(CONCAT('%', :nombre,'%'))) ORDER BY o.codigo ASC ")
	List<OTipoCuaderno> findByNombreLikeIgnoreCase(@Param("nombre") String nombre);
//
//	@Query(value = "DECLARE @retval INT " + " EXEC @retval = [Administracion].[SiguienteCodigoCuaderno] "
//			+ " SELECT @retval ", nativeQuery = true)
//	BigInteger findBySiguienteCodigo();

	@Query(value = "SELECT MIN(c.codigo) + 1 FROM OTipoCuaderno c WHERE NOT EXISTS (SELECT 1 FROM OTipoCuaderno o WHERE o.codigo = c.codigo + 1)")
	BigInteger findBySiguienteCodigoQuery();
	

	Optional<OTipoCuaderno> findByNombre(String nombre);

}