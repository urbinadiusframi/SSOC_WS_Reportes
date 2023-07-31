package co.gov.ssoc.gedess.sgd.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.ORadicacionAsync;

@Repository
public interface RadicacionAsyncRepository extends JpaRepository<ORadicacionAsync, Long>
//		,org.springframework.data.repository.history.RevisionRepository<ORadicacion, Long, Long>
{

}