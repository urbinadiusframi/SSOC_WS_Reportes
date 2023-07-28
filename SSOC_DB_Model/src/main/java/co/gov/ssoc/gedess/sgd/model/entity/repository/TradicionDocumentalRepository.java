package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OTradicionDocumental;

@Repository
public interface TradicionDocumentalRepository extends JpaRepository<OTradicionDocumental, Long> //, org.springframework.data.repository.history.RevisionRepository<OTradicionDocumental, Long , Long>
{
	
	List<OTradicionDocumental> findByNombreIgnoreCaseIn(List<String> nombre);
	Optional<OTradicionDocumental> findByNombre(String nombre);
}
