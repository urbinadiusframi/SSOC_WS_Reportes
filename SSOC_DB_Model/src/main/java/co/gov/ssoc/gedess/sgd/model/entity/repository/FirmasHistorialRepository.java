package co.gov.ssoc.gedess.sgd.model.entity.repository;	

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OFirmaElectronicaHistorico;

@Repository
public interface FirmasHistorialRepository extends JpaRepository<OFirmaElectronicaHistorico, Long> {

}