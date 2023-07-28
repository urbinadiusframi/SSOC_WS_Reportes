package co.gov.ssoc.gedess.sgd.model.entity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumentalTradicion;
@Repository
public interface TipoDocumentalTradicionRepository extends JpaRepository<OTipoDocumentalTradicion, Long> //, org.springframework.data.repository.history.RevisionRepository<OTipoDocumentalTradicion, Long , Long>
{

}