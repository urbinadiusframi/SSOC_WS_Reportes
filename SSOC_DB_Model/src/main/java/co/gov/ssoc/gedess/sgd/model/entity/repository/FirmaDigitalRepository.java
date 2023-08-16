package co.gov.ssoc.gedess.sgd.model.entity.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OEstadoRadicacion;
import co.gov.ssoc.gedess.sgd.model.entity.OFirmaDigital;
import co.gov.ssoc.gedess.sgd.model.entity.ORadicacion;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumental;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoRadicacion;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoSeguridad;
import co.gov.ssoc.gedess.sgd.model.entity.OTramite;

@Repository
public interface FirmaDigitalRepository extends JpaRepository<OFirmaDigital, Long>
//		,org.springframework.data.repository.history.RevisionRepository<ORadicacion, Long, Long>
{
	List<OFirmaDigital> findByNumeroRadicadoIn(List<String> numerosRadicado);

	@Query(value = "SELECT NEXT VALUE FOR [Administracion].[sqc_camerfirma_id_app]", nativeQuery = true)
	BigInteger getSiguienteIdApp();

	@Query(value = "SELECT NEXT VALUE FOR [Administracion].[sqc_camerfirma_id_user]", nativeQuery = true)
	BigInteger getSiguienteIdUser();
}