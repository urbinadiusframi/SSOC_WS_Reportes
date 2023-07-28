package co.gov.ssoc.gedess.sgd.model.entity.repository;

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
import co.gov.ssoc.gedess.sgd.model.entity.ORadicacion;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumental;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoRadicacion;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoSeguridad;
import co.gov.ssoc.gedess.sgd.model.entity.OTramite;

@Repository
public interface RadicacionRepository extends JpaRepository<ORadicacion, Long>
//		,org.springframework.data.repository.history.RevisionRepository<ORadicacion, Long, Long>
{

	@Procedure("ORadicacion.getConsecutiveRadicado")
	String getConsecutiveRadicado(@Param("SeqName") String sequenceName);

	@Procedure("ORadicacion.getConsecutiveBorrador")
	String getConsecutiveBorrador(@Param("SeqName") String sequenceName);

	@Query(value = "SELECT r FROM ORadicacion r WHERE r.applyToSocietyIdentification = :sociedadId AND r.tipoSeguridad = :tpSeguridad AND r.stateRadicado IN :estados AND ( r.documentaryType = :documentaryType1 AND r.dateRadication < :ayer ) OR r.documentaryType = :documentaryType2 OR r.documentaryType = :documentaryType3")
	List<ORadicacion> searchBySociedad(@Param("sociedadId") String sociedadId,
			@Param("tpSeguridad") OTipoSeguridad tpSeguridad, @Param("estados") List<OEstadoRadicacion> estados,
			@Param("documentaryType1") OTipoDocumental documentaryType1, @Param("ayer") Date ayer,
			@Param("documentaryType2") OTipoDocumental documentaryType2,
			@Param("documentaryType3") OTipoDocumental documentaryType3);

	@Query(value = "SELECT r FROM ORadicacion r WHERE r.applyToSocietyIdentification = :sociedadId AND  r.tipoSeguridad=:tpSeguridad AND r.stateRadicado IN :estados AND (r.documentaryType=:documentaryType1 OR r.documentaryType=:documentaryType2 OR r.documentaryType=:documentaryType3 OR r.documentaryType=:documentaryType4)AND r.dateRadication < :ayer")
	List<ORadicacion> searchBySociedad2(@Param("sociedadId") String sociedadId, @Param("ayer") Date ayer,
			@Param("tpSeguridad") OTipoSeguridad tpSeguridad, @Param("estados") List<OEstadoRadicacion> estados,
			@Param("documentaryType1") OTipoDocumental documentaryType1,
			@Param("documentaryType2") OTipoDocumental documentaryType2,
			@Param("documentaryType3") OTipoDocumental documentaryType3,
			@Param("documentaryType4") OTipoDocumental documentaryType4);

	@Query(value = "SELECT r FROM ORadicacion r WHERE r.applyToSocietyIdentification = :sociedadId AND  r.tipoSeguridad=:tpSeguridad AND (r.dateRadication<:fechaF) AND (:fechaI<:fechaF) ")
	List<ORadicacion> entradaBySociedad(@Param("sociedadId") String sociedadId, @Param("fechaI") Date fechaI,
			@Param("fechaF") Date fechaF, @Param("tpSeguridad") OTipoSeguridad tpSeguridad);

	@Query(value = "SELECT r FROM ORadicacion r WHERE r.tramite IN :tramites")
	List<ORadicacion> consultaTramite(@Param("tramites") List<OTramite> tramites);

	@Query(value = "SELECT r FROM ORadicacion r WHERE r.tramite IN :tramites AND r.tipoSeguridad=:tpSeguridad AND r.stateRadicado IN :estados AND r.assignedDependencyName=:dependencia AND (r.dateRadication<:fechaF) AND (r.dateRadication>:fechaI)")
	List<ORadicacion> consultaTramite(@Param("tramites") List<OTramite> tramites,
			@Param("tpSeguridad") OTipoSeguridad tpSeguridad, @Param("estados") List<OEstadoRadicacion> estados,
			@Param("dependencia") String dependencia, @Param("fechaI") Date fechaI, @Param("fechaF") Date fechaF);

	@Query(value = "SELECT r FROM ORadicacion r WHERE r.tramite IN :tramites AND r.assignedDependencyName=:dependencia AND  (r.dateRadication<:fechaF) AND (r.dateRadication>:fechaI) AND  r.documentaryType=:documentaryType1")
	List<ORadicacion> estadosByFechaDepTipdoc(@Param("dependencia") String dependencia, @Param("fechaI") Date fechaI,
			@Param("fechaF") Date fechaF, @Param("tramites") List<OTramite> tramites,
			@Param("documentaryType1") OTipoDocumental documentaryType1);

	@Query(value = "SELECT r FROM ORadicacion r WHERE r.tramite IN :tramites AND r.assignedDependencyName=:dependencia AND  (r.dateRadication<:fechaF) AND (r.dateRadication>:fechaI) ")
	List<ORadicacion> estadosByFechaDep(@Param("dependencia") String dependencia, @Param("fechaI") Date fechaI,
			@Param("fechaF") Date fechaF, @Param("tramites") List<OTramite> tramites);

	@Query(value = "SELECT r FROM ORadicacion r WHERE r.tramite IN :tramites AND r.tipoSeguridad=:tpSeguridad AND r.stateRadicado IN :estados AND r.assignedDependencyName=:dependencia AND (r.dateRadication<:fechaF) AND (r.dateRadication>:fechaI) AND r.documentaryType=:documentaryType1")
	List<ORadicacion> sentenciaByFechaDep(@Param("tramites") List<OTramite> tramites,
			@Param("tpSeguridad") OTipoSeguridad tpSeguridad, @Param("estados") List<OEstadoRadicacion> estados,
			@Param("dependencia") String dependencia, @Param("fechaI") Date fechaI, @Param("fechaF") Date fechaF,
			@Param("documentaryType1") OTipoDocumental documentaryType1);

	@Query(value = "SELECT r FROM ORadicacion r WHERE r.tramite IN :tramites AND r.assignedDependencyName=:dependencia AND (r.dateRadication<:fechaF) AND (r.dateRadication>:fechaI)")
	List<ORadicacion> avisosByFecha(@Param("tramites") List<OTramite> tramites,
			@Param("dependencia") String dependencia, @Param("fechaI") Date fechaI, @Param("fechaF") Date fechaF);

	@Query(value = "SELECT r FROM ORadicacion r WHERE  r.assignedDependencyName=:dependencia AND  (r.dateRadication<:fechaF) AND (r.dateRadication>:fechaI)")
	List<ORadicacion> trasladosByFecha(@Param("dependencia") String dependencia, @Param("fechaI") Date fechaI,
			@Param("fechaF") Date fechaF);

	@Query(value = "SELECT r FROM ORadicacion r WHERE  r.assignedDependencyName=:dependencia AND  (r.dateRadication<:fechaF) AND (r.dateRadication>:fechaI) AND r.documentaryType=:documentaryType1")
	List<ORadicacion> trasladosByFechaDepTipdoc(@Param("dependencia") String dependencia, @Param("fechaI") Date fechaI,
			@Param("fechaF") Date fechaF, @Param("documentaryType1") OTipoDocumental documentaryType1);

	@Query(value = "SELECT r FROM ORadicacion r WHERE r.tipoSeguridad = :tpSeguridad AND r.stateRadicado IN :estados")
	List<ORadicacion> searchRadicadosByTipoSeguridadAndEstado(@Param("tpSeguridad") OTipoSeguridad tpSeguridad,
			@Param("estados") List<OEstadoRadicacion> estados);

	@Query(value = "SELECT r FROM ORadicacion r WHERE r.stateRadicado IN :estados")
	List<ORadicacion> searchRadicadosByEstado(@Param("estados") List<OEstadoRadicacion> estados);

	Optional<ORadicacion> findByNumberRadicado(String numberRadicado);

	Optional<ORadicacion> findByNumberRadicadoOrTipoDocumentalConsecutivoAndDocumentaryTypeIn(String numberRadicado,
			String tipoDocumentalConsecutivo, List<OTipoDocumental> documentaryType);

	Optional<ORadicacion> findByNumeroBorrador(String numeroBorrador);

	Optional<ORadicacion> findByTramiteAndNumberRadicadoNotContaining(String numberTramite, String notBorrador);

	List<ORadicacion> findByDateRadicationBetweenAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, String notBorrador);

	List<ORadicacion> findByDateRadicationBetweenAndTipoSeguridadInAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, List<OTipoSeguridad> tipoSeguridad, String notBorrador);

	List<ORadicacion> findByDateRadicationBetweenAndApplyToSocietyIdentificationAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, String applyToSocietyIdentification, String notBorrador);

	List<ORadicacion> findByDateRadicationBetweenAndApplyToSocietyIdentificationAndDocumentaryTypeInAndStateRadicadoInAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, String applyToSocietyIdentification,
			List<OTipoDocumental> documentaryType, List<OEstadoRadicacion> ltEstadRadic, String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndDocumentaryTypeInAndSenderDependencyIdInAndTypeRadicationInAndStateRadicadoInAndProcessProcedureCodeInAndNumberRadicadoNotContainingOrderBySenderDependencyIdDesc(
			Date fechaInicial, Date fechaFinal, List<OTipoDocumental> documentaryType, List<String> senderDependencyId,
			List<OTipoRadicacion> tiposRadicacion, List<OEstadoRadicacion> ltEstadRadic, List<Integer> procesos,
			Pageable pageable, String notBorrador);

	List<ORadicacion> findByDateRadicationBetweenAndDocumentaryTypeInAndSenderDependencyIdInAndTypeRadicationInAndStateRadicadoInAndProcessProcedureCodeInAndNumberRadicadoNotContainingOrderBySenderDependencyIdDesc(
			Date fechaInicial, Date fechaFinal, List<OTipoDocumental> documentaryType, List<String> senderDependencyId,
			List<OTipoRadicacion> tiposRadicacion, List<OEstadoRadicacion> ltEstadRadic, List<Integer> procesos,
			String notBorrador);

	List<ORadicacion> findByDateRadicationBetweenAndDocumentaryTypeInAndTypeRadicationInAndStateRadicadoInAndProcessProcedureCodeInAndNumberRadicadoNotContainingOrderBySenderDependencyIdDesc(
			Date fechaInicial, Date fechaFinal, List<OTipoDocumental> documentaryType,
			List<OTipoRadicacion> tiposRadicacion, List<OEstadoRadicacion> ltEstadRadic, List<Integer> procesos,
			String notBorrador);

	List<ORadicacion> findByDateRadicationBetweenAndDocumentaryTypeInAndTypeRadicationInAndStateRadicadoInAndNumberRadicadoNotContainingOrderBySenderDependencyIdDesc(
			Date fechaInicial, Date fechaFinal, List<OTipoDocumental> documentaryType,
			List<OTipoRadicacion> tiposRadicacion, List<OEstadoRadicacion> ltEstadRadic, String numeroRadicado);

	List<ORadicacion> findByDateRadicationBetweenAndTypeRadicationInAndStateRadicadoInAndNumberRadicadoNotContainingOrderBySenderDependencyIdDesc(
			Date fechaInicial, Date fechaFinal, List<OTipoRadicacion> tiposRadicacion,
			List<OEstadoRadicacion> ltEstadRadic, String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndDocumentaryTypeInAndSenderDependencyIdInAndTramiteInAndNumberRadicadoNotContaining(
			Date fechaInicial, Date fechaFinal, List<OTipoDocumental> documentaryType, List<String> senderDependencyId,
			List<OTramite> tramites, Pageable pageable, String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndSenderDependencyIdInAndTramiteInAndNumberRadicadoNotContaining(
			Date fechaInicial, Date fechaFinal, List<String> senderDependencyId, List<OTramite> tramites,
			Pageable pageable, String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndNumberRadicado(Date fechaInicial, Date fechaFinal,
			String numberRadicado, Pageable pageable);

	Page<ORadicacion> findByNumberRadicadoAndAndApplyToSocietyExpedienteSs(String numberRadicado, String expediente,
			Pageable pageable);

	Page<ORadicacion> findByDateRadicationBetweenAndSenderDependencyIdInAndTramiteInAndTipoSeguridadInAndNumberRadicadoNotContaining(
			Date fechaInicial, Date fechaFinal, List<String> senderDependencyId, List<OTramite> tramites,
			List<OTipoSeguridad> tipoSeguridad, Pageable pageable, String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndSenderDependencyIdInAndTramiteInAndTipoSeguridadInAndDocumentaryTypeInAndNumberRadicadoNotContaining(
			Date fechaInicial, Date fechaFinal, List<String> senderDependencyId, List<OTramite> tramites,
			List<OTipoSeguridad> tipoSeguridad, List<OTipoDocumental> documentaryType, Pageable pageable,
			String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndTramiteInAndDocumentaryTypeAndAssignedDependencyIdInAndTipoSeguridadInAndNumberRadicadoNotContaining(
			Date fechaInicial, Date fechaFinal, List<OTramite> tramites, Optional<OTipoDocumental> documentaryType,
			List<String> assignedDependencyId, List<OTipoSeguridad> tipoSeguridad, Pageable pageable,
			String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndTramiteInAndDocumentaryTypeInAndAssignedDependencyIdInAndTipoSeguridadInAndNumberRadicadoNotContaining(
			Date fechaInicial, Date fechaFinal, List<OTramite> tramites, List<OTipoDocumental> documentaryType,
			List<String> assignedDependencyId, List<OTipoSeguridad> tipoSeguridad, String notBorrador,
			Pageable pageable);

	Page<ORadicacion> findByDateRadicationBetweenAndTramiteInAndDocumentaryTypeInAndAssignedDependencyNameInAndTipoSeguridadInAndNumberRadicadoNotContaining(
			Date fechaInicial, Date fechaFinal, List<OTramite> tramites, List<OTipoDocumental> documentaryType,
			List<String> assignedDependencyId, List<OTipoSeguridad> tipoSeguridad, String notBorrador,
			Pageable pageable);

	Page<ORadicacion> findByDateRadicationBetweenAndTramiteInAndDocumentaryTypeInAndAssignedDependencyIdInAndNumberRadicadoNotContaining(
			Date fechaInicial, Date fechaFinal, List<OTramite> tramites, List<OTipoDocumental> documentaryType,
			List<String> assignedDependencyId, Pageable pageable, String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndDocumentaryTypeInAndAssignedDependencyIdInAndNumberRadicadoNotContaining(
			Date fechaInicial, Date fechaFinal, List<OTipoDocumental> documentaryType,
			List<String> assignedDependencyId, Pageable pageable, String notBorrador);

	List<ORadicacion> findByDateRadicationBetweenAndTramite(Date fechaInicial, Date fechaFinal,
			Optional<OTramite> tramite);

	List<ORadicacion> findByDateRadicationBetweenAndTramiteIn(Date fechaInicial, Date fechaFinal,
			List<OTramite> tramite);

	List<ORadicacion> findByDateRadicationBetweenAndApplyToSocietyExpedienteSs(Date fechaInicial, Date fechaFinal,
			String expediente);

	Page<ORadicacion> findByDateRadicationBetweenAndSenderDependencyIdInAndTramiteInAndTipoSeguridadAndStateRadicadoInAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, List<String> senderDependencyId, List<OTramite> tramites,
			OTipoSeguridad tipoSeguridad, Pageable pageable, List<OEstadoRadicacion> stateRadicado, String notBorrador);

	Page<ORadicacion> TramiteInAndTipoSeguridadAndStateRadicadoInAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			List<OTramite> tramites, OTipoSeguridad tipoSeguridad, Pageable pageable,
			List<OEstadoRadicacion> stateRadicado, String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndSenderDependencyIdInAndTramiteInAndTipoSeguridadAndStateRadicadoInAndDocumentaryTypeInAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, List<String> senderDependencyId, List<OTramite> tramites,
			OTipoSeguridad tipoSeguridad, Pageable pageable, List<OEstadoRadicacion> stateRadicado,
			List<OTipoDocumental> documentaryType, String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndSenderDependencyIdInAndTramiteInAndStateRadicadoInAndDocumentaryTypeInAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, List<String> senderDependencyId, List<OTramite> tramites,
			Pageable pageable, List<OEstadoRadicacion> stateRadicado, List<OTipoDocumental> documentaryType,
			String notBorrador);

	List<ORadicacion> findByDateRadicationBetweenAndSenderDependencyIdInAndTramiteInAndStateRadicadoInAndDocumentaryTypeInAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, List<String> senderDependencyId, List<OTramite> tramites,
			List<OEstadoRadicacion> stateRadicado, List<OTipoDocumental> documentaryType, String notBorrador);

	List<ORadicacion> findByDateRadicationBetweenAndTramiteInAndStateRadicadoInAndDocumentaryTypeInAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, List<OTramite> tramites, List<OEstadoRadicacion> stateRadicado,
			List<OTipoDocumental> documentaryType, String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndStateRadicadoInAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, List<OEstadoRadicacion> ltEstadRadic, Pageable pageable,
			String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndDocumentaryTypeInAndStateRadicadoInAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, List<OTipoDocumental> documentaryType,
			List<OEstadoRadicacion> ltEstadRadic, Pageable pageable, String notBorrador);

	Page<ORadicacion> findByDateRadicationBetweenAndDocumentaryTypeInAndStateRadicadoInAndTipoSeguridadAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, List<OTipoDocumental> documentaryType,
			List<OEstadoRadicacion> ltEstadRadic, OTipoSeguridad tipoSeguridad, String notBorrador, Pageable pageable);

	Page<ORadicacion> findByDateRadicationBetweenAndStateRadicadoInAndTipoSeguridadAndNumberRadicadoNotContainingOrderByDateRadicationDesc(
			Date fechaInicial, Date fechaFinal, List<OEstadoRadicacion> ltEstadRadic, OTipoSeguridad tipoSeguridad,
			String notBorrador, Pageable pageable);

	List<ORadicacion> findByDocumentaryTypeInAndTypeRadicationInAndStateRadicadoInAndNumberRadicadoNotContainingOrderBySenderDependencyIdDesc(
			List<OTipoDocumental> documentaryType, List<OTipoRadicacion> tiposRadicacion,
			List<OEstadoRadicacion> ltEstadRadic, String notBorrador);

	List<ORadicacion> findByDateRadicationBetweenAndDocumentaryTypeInAndTypeRadicationInAndStateRadicadoInAndNumberRadicadoOrderBySenderDependencyIdDesc(
			Date fechaInicial, Date fechaFinal, List<OTipoDocumental> documentaryType,
			List<OTipoRadicacion> tiposRadicacion, List<OEstadoRadicacion> ltEstadRadic, String numeroRadicado);

	List<ORadicacion> findByDateRadicationBetweenAndApplyToSocietyIdentification(Date fechaInicial, Date fechaFinal,
			String applyToSocietyIdentification);

	List<ORadicacion> findByDateRadicationBetweenAndApplyToSocietyIdentificationAndDocumentaryTypeInAndTipoSeguridadIn(
			Date fechaInicial, Date fechaFinal, String applyToSocietyIdentification,
			List<OTipoDocumental> documentaryType, List<OTipoSeguridad> tipoSeguridad);

	List<ORadicacion> findByDateRadicationBetweenAndNumberRadicadoAndConsecutivoEspecialAndTramiteInAndDocumentaryTypeIn(
			Date fechaInicial, Date fechaFinal, String numberRadicado, String consecutivoEspecial,
			List<OTramite> tramites, List<OTipoDocumental> documentaryType);

	List<ORadicacion> findByDateRadicationBetweenAndNumberRadicado(Date fechaInicial, Date fechaFinal,
			String numberRadicado);

	boolean existsByNumberRadicado(String numeroRadicado);

	List<ORadicacion> findAllBynumberRadicado(String numeroRadicado);
	/*
	 * @Procedure("ORadicacion.getRadicadosByFilters") // @Query(value =
	 * "EXEC correspondencia.SP_LISTAR_RADICADOS_BY_FILTERS :fechaInicial, :fechaFinal, :estados_radicacion_list, :dependencias_list, :tipos_radicacion_list, :tramites_list, :tipos_documentales_list "
	 * , nativeQuery = true) String
	 * getRadicadosByFilters(@Param("fechaInicial")String
	 * fechaInicial,@Param("fechaFinal")String
	 * fechaFinal,@Param("estados_radicacion_list")Integer[]
	 * estados_radicacion_list,
	 * 
	 * @Param("dependencias_list")Integer[]
	 * dependencias_list,@Param("tipos_radicacion_list")Integer[]
	 * tipos_radicacion_list,
	 * 
	 * @Param("tramites_list")Integer[]
	 * tramites_list,@Param("tipos_documentales_list")Integer[]
	 * tipos_documentales_list, String json);
	 */

	@Query("SELECT COUNT(r.numberRadicado) + 1 FROM ORadicacion r WHERE SUBSTRING(r.numberRadicado, 1, 4) = :anio ")
	Long getCountByYear(@Param("anio") String anio);

	@Query("SELECT COUNT(r.numeroBorrador) + 1 FROM ORadicacion r WHERE SUBSTRING(r.numeroBorrador, 2, 2) = :anio ")
	Long getCountBByYear(@Param("anio") String anio);

	@Modifying
	@Query(value = "ALTER SEQUENCE correspondencia.sqc_radicado RESTART WITH 1", nativeQuery = true)
	void resetSequence();

	@Modifying
	@Query(value = "ALTER SEQUENCE correspondencia.sqc_borrador RESTART WITH 1", nativeQuery = true)
	void resetSequenceB();

}