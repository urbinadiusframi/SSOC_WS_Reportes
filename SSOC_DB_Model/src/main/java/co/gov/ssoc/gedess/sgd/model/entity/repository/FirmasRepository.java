package co.gov.ssoc.gedess.sgd.model.entity.repository;	

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OFirmaElectronica;

@Repository
public interface FirmasRepository extends JpaRepository<OFirmaElectronica, Long> {

	Optional<OFirmaElectronica> findByNumeroIdentificacionOrUsernameIgnoreCaseAndEstado(String numeroIdentificacion, String username,Boolean estado);
	Optional<List<OFirmaElectronica>> findByNumeroIdentificacionInAndEstado(List<String> numeroIdentificacion, Boolean estado); 
	
}