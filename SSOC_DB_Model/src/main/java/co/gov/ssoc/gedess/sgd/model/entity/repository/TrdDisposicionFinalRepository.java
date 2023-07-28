package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTrdDisposicionalFinal;

@Repository
public interface TrdDisposicionFinalRepository extends JpaRepository<OTrdDisposicionalFinal, Long> //, org.springframework.data.repository.history.RevisionRepository<OTrdDisposicionalFinal, Long , Long>
{

	@Query(value = "SELECT d.trdDisposicionFinalPK.disposionFinal.nombre FROM OTrdDisposicionalFinal d WHERE d.trdDisposicionFinalPK.trd.id = :idTrd ")
	List<String> searchDisposicionFinalByTrd(@Param("idTrd") Long idTrd);
}