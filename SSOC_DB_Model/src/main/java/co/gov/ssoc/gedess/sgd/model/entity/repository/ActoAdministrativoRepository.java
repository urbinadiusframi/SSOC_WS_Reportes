package co.gov.ssoc.gedess.sgd.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OActoAdministrativo;

@Repository
public interface ActoAdministrativoRepository extends JpaRepository<OActoAdministrativo, Long>
//,		org.springframework.data.repository.history.RevisionRepository<OActoAdministrativo, Long, Long> 
{

}
