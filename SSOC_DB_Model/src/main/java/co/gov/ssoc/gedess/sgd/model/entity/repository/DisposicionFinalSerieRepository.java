package co.gov.ssoc.gedess.sgd.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.ODisposicionFinalSerie;

@Repository
public interface DisposicionFinalSerieRepository extends JpaRepository<ODisposicionFinalSerie, Long>
//, org.springframework.data.repository.history.RevisionRepository<ODisposicionFinalSerie, Long, Long>>
{

	@Query(value = "SELECT MAX(t.version) FROM ODisposicionFinalSerie t WHERE t.codigoUnidadAdministrativa = :depen AND t.codigoOficinaProductora = :oficina")
	Integer searchVersionByDependenciaAndOficina(@Param("depen") Integer depen, @Param("oficina") Integer oficina);

}
