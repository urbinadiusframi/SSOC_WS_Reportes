package co.gov.ssoc.gedess.sgd.model.entity.repository;	


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.gov.ssoc.gedess.sgd.model.entity.HashFirmaPersona;
import co.gov.ssoc.gedess.sgd.model.entity.OHashFirmaDocumento;

public interface HashFirmaPersonaRepository extends JpaRepository<HashFirmaPersona,Long> {

    List<HashFirmaPersona> findHashFirmaPersonaByIdHashFirmaDocumentoAndAndTipoPersona(OHashFirmaDocumento entity, String tipoPersona);
    List<HashFirmaPersona> findAllByIdHashFirmaDocumento(OHashFirmaDocumento oHashFirmaDocumento);
    List<HashFirmaPersona> findAllByTipoPersonaAndIdHashFirmaDocumento(String tipoPersona, OHashFirmaDocumento oHashFirmaDocumento);


}
