package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OSerie;
import co.gov.ssoc.gedess.sgd.model.entity.OSeriesCuaderno;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoCuaderno;

@Repository
public interface SerieCuadernoRepository extends JpaRepository<OSeriesCuaderno, Long> //, org.springframework.data.repository.history.RevisionRepository<OSeriesCuaderno, Long , Long>
{
	
	@Query(value = "SELECT sc.serieCuadernoPK.cuaderno FROM OSeriesCuaderno sc WHERE sc.serieCuadernoPK.serie = :serie")
	List<OTipoCuaderno> searchCuadernoBySerie(@Param("serie") OSerie serie);	

}