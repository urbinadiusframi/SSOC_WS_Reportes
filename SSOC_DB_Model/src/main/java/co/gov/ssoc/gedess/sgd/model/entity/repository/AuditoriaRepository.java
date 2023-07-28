package co.gov.ssoc.gedess.sgd.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OAuditoria;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuditoriaRepository extends JpaRepository<OAuditoria, Long>
//,org.springframework.data.repository.history.RevisionRepository<OAuditoria, Long, Long> 
{
	@Override
	Optional<OAuditoria> findById(Long aLong);

	List<OAuditoria> findAllByModulo(String modulo);

	List<OAuditoria> findByFechaCargueBetweenAndModulo(Date FechaInicio, Date FechaFinal, String modulo);

	List<OAuditoria> findByFechaCargueBetween(Date FechaInicio, Date FechaFinal);

	List<OAuditoria> findByFechaCargueBetweenAndTipoAccion(Date FechaInicio, Date FechaFinal, String tipoAccion);

	List<OAuditoria> findByFechaCargueBetweenAndUsuario(Date FechaInicio, Date FechaFinal, String user);
}
