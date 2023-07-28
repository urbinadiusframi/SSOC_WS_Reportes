package co.gov.ssoc.gedess.sgd.model.entity.repository;	



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ssoc.gedess.sgd.model.entity.OHashFirmaDocumento;


public interface HashFirmaDocumentoRepository extends JpaRepository<OHashFirmaDocumento, Long> {

    List<OHashFirmaDocumento> findByNumeroRadicado(String numberRadicado);


    boolean existsByNumeroRadicado(String numeroRadicado);
    boolean existsByNumeroBorrador(String numeroBorrador);

    Optional<OHashFirmaDocumento> findByNumeroBorrador(String numeroBorrador);
    List<OHashFirmaDocumento> findOHashFirmaDocumentoByHash1AndAndHash2OrHash1AndAndHash3OrHash1AndAndHash4OrAndHash1AndHash5OrAndHash1AndHash6(
            String hash1, String Has2, String hash11, String hash3, String hash111, String hash4, String hash1111, String hash5, String hash, String hash6);
    List<OHashFirmaDocumento> findOHashFirmaDocumentoByHash2AndHash3OrHash2AndHash4OrHash2AndAndHash5OrHash2AndHash6(
            String hash2, String Has3,String hash22, String Has4,String hash222, String Has5,String hash2222, String Has6);
    List<OHashFirmaDocumento> findOHashFirmaDocumentoByHash3AndHash4OrHash3AndHash5OrHash3AndAndHash6(
            String hash3, String Has4,String hash33, String Has5,String hash333, String Has6);
    List<OHashFirmaDocumento> findOHashFirmaDocumentoByHash4AndHash5OrHash4AndHash6(
            String hash4, String Has5,String hash44, String Has6);
    List<OHashFirmaDocumento> findOHashFirmaDocumentoByHash5AndHash6(String hash5, String Has6);






    @Procedure(name = "SP_ConsultaHash")
    @Transactional
    List<OHashFirmaDocumento> idHashDocumento(
            @Param("hash1") String hash1,
            @Param("hash2") String hash2,
            @Param("hash3") String hash3,
            @Param("hash4") String hash4,
            @Param("hash5") String hash5,
            @Param("hash6") String hash6);



}
