package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.PrePersist;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@org.hibernate.envers.Audited
@Table(name = "Radicaciones", schema="correspondencia")
@NamedStoredProcedureQuery(name = "ORadicacion.getConsecutiveRadicado", 
procedureName = "correspondencia.SP_GET_CONSECUTIVE_RADICADO", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "SeqName", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "NewNum", type = String.class)})

@NamedStoredProcedureQuery(name = "ORadicacion.getConsecutiveBorrador",
procedureName = "correspondencia.SP_GET_CONSECUTIVE_BORRADOR", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "SeqName", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "NewNum", type = String.class)})

/*
@NamedStoredProcedureQuery(name = "ORadicacion.getRadicadosByFilters", 
procedureName = "correspondencia.SP_LISTAR_RADICADOS_BY_FILTERS", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "fechaInicial", type = Date.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "fechaFinal", type = Date.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "estados_radicacion_list", type = Array.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "dependencias_list", type = Array.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "tipos_radicacion_list", type = Array.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "tramites_list", type = Array.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "tipos_documentales_list",type = Array.class),
  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "JsonListadoRadic", type = String.class)})
  */
public class ORadicacion implements Serializable {

	private static final long serialVersionUID = 2909L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "number_radicado")
	private String numberRadicado;
	
	@ManyToOne
    @JoinColumn(name = "type_radication")
	private OTipoRadicacion typeRadication;
	
	@ManyToOne
    @JoinColumn(name="procedure_id")
	private OTramite tramite;
	
	@Column(name = "name_radicador")
	private String nameRadicador;
	@Column(name = "number_identificacion_radicador")
	private String numberIdentificacionRadicador;
	@Column(name = "type_identificacion_radicador")
	private String typeIdentificacionRadicador;
	
	@Column(name = "date_radication")
	private Date dateRadication;

	@ManyToOne
    @JoinColumn(name = "state_radicado")
	private OEstadoRadicacion stateRadicado;
	
	@Column(name = "number_folios")
	private int numberFolios;
	
	@Column(name = "assigned_dependency_id")
	private Integer assignedDependencyId;
	@Column(name = "assigned_dependency_name")
	private String assignedDependencyName;
	
	@Column(name = "assigned_officer_identification")
	private String assignedOfficerIdentification;
	@Column(name = "assigned_officer_name")
	private String assignedOfficerName;
	
	@Column(name = "assigned_officer_lastname")
	private String assignedOfficerLastname;
	@Column(name = "assigned_officer_nemotecnico")
	private String assignedOfficerNemotecnico;
	@Column(name = "assigned_officer_codigo")
	private String assignedOfficerCodigo;
	@Column(name = "assigned_officer_cargo")
	private String assignedOfficerCargo;
	
	@Column(name = "sender_dependency_id")
	private String senderDependencyId;
	@Column(name = "sender_dependency_name")
	private String senderDependencyName;
	@Column(name = "sender_identification_number")
	private String senderIdentificationNumber;
	@Column(name = "sender_identification_type")
	private String senderIdentificationType;
	@Column(name = "sender_identification_type_code")
	private String senderIdentificationTypeCode;
	
	@Column(name = "sender_email")
	private String senderEmail;
	@Column(name = "sender_name")
	private String senderName;
	@Column(name = "sender_address")
	private String senderAddress;
	@Column(name = "sender_phone")
	private String senderPhone;
	@Column(name = "tipo_corresponsal")
	private String tipoCorresponsal; //"Particular" o "Dependencia"
	@Column(name = "city_code_corresponsal")
	private String cityCodeCorresponsal;
	@Column(name = "city_name_corresponsal")
	private String cityNameCorresponsal;
	@Column(name = "departament_code_corresponsal")
	private String departamentCodeCorresponsal;
	@Column(name = "departament_name_corresponsal")
	private String departamentNameCorresponsal;
	@Column(name = "country_code_corresponsal")
	private String countryCodeCorresponsal;
	@Column(name = "country_name_corresponsal")
	private String countryNameCorresponsal;	
	
	@Column(name = "sending_channel")
	private String sendingChannel;
	@Column(name = "sending_channel_code")
	private String sendingChannelCode;
	@Column(name = "days_term")
	private int daysTerm;	
	@Column(name = "date_term_vigence")
	private Date dateTermVigence;
	@Column(name = "number_radication_last")
	private String numberRadicationLast;
	
	@Column(name = "apply_to_society_expediente_ss")
	private String applyToSocietyExpedienteSs;

	@Column(name = "apply_to_society_type_identification")
	private String applyToSocietyTypeIdentification;
	@Column(name = "apply_to_society_identification")
	private String applyToSocietyIdentification;
	@Column(name = "apply_to_society_name")
	private String applyToSocietyName;
	@Column(name = "apply_to_society_address")
	private String applyToSocietyAddress;
	@Column(name = "apply_to_society_city")
	private String applyToSocietyCity;
	@Column(name = "apply_to_society_type_identification_code")
	private String applyToSocietyTypeIdentificationCode;
	@Column(name = "apply_to_society_email")
	private String applyToSocietyEmail;
	@Column(name = "apply_to_society_phone")
	private String applyToSocietyPhone;
	
	@Column(name = "process_procedure_code")
	private Integer processProcedureCode;
	@Column(name = "process_procedure_name")
	private String processProcedureName;
	
	@ManyToOne
    @JoinColumn(name = "documentary_type")
	private OTipoDocumental documentaryType;
	@Column(name = "tipo_documental_consecutivo")
	private String tipoDocumentalConsecutivo;
	
	@ManyToOne
    @JoinColumn(name = "type_notebook")
	private OTipoCuaderno tipoCuaderno;
	
	@ManyToOne
    @JoinColumn(name = " id_tipo_seguridad")
	private OTipoSeguridad tipoSeguridad;
	
	@Column(name = "physical_attachment")
	private String physicalAttachment;
	@Column(name = "physical_delivery")
	private Boolean physicalDelivery;
	private Float penalty;
	@Column(name = "external_reference")
	private String externalReference;

	@Column(name = "numero_borrador")
	private String numeroBorrador;
	@Column(name = "fecha_borrador")
	private Date fechaBorrador;
	
	@Column(name = "consecutivo_especial")
	private String consecutivoEspecial;//adicionado by JCONEJO
	
	@Column(name = "tipo_registro")
	private String tipoRegistro;//adicionado by JCONEJO

	@PrePersist
	private void prePersistFunction() {
		this.dateRadication = new Date();
	}
}