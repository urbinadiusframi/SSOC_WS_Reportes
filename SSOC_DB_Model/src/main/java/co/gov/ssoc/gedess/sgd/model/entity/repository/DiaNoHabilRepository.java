package co.gov.ssoc.gedess.sgd.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.ODiaNoHabil;

@Repository
public interface DiaNoHabilRepository extends JpaRepository<ODiaNoHabil, Long>
//, org.springframework.data.repository.history.RevisionRepository<ODiaNoHabil, Long, Long>>
{

}