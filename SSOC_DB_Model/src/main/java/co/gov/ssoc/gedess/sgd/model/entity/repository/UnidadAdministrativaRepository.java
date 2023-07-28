package co.gov.ssoc.gedess.sgd.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OUnidadAdministrativa;

@Repository
public interface UnidadAdministrativaRepository extends JpaRepository<OUnidadAdministrativa, Long> //, org.springframework.data.repository.history.RevisionRepository<OUnidadAdministrativa, Long , Long>
{

}
