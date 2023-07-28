package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OSerie;
import co.gov.ssoc.gedess.sgd.model.entity.OSeriesCuaderno;
import co.gov.ssoc.gedess.sgd.model.entity.OSubSerie;
import co.gov.ssoc.gedess.sgd.model.entity.OSubSeriesCuaderno;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoCuaderno;

@Repository
public interface SubSerieCuadernoRepository extends JpaRepository<OSubSeriesCuaderno, Long> //, org.springframework.data.repository.history.RevisionRepository<OSubSeriesCuaderno, Long , Long>
{

	@Query(value = "SELECT sc.serieCuadernoPK.cuaderno FROM OSubSeriesCuaderno sc WHERE sc.serieCuadernoPK.subserie = :subserie")
	List<OTipoCuaderno> searchCuadernoBySerie(@Param("subserie") OSubSerie subserie);

}