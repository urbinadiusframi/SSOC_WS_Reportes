package co.gov.ssoc.gedess.sgd.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
//@org.hibernate.envers.Audited
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Hash_Firma_Documento", schema = "correspondencia")
@Data
@NamedStoredProcedureQuery(name = "SP_ConsultaHash", procedureName = "correspondencia.SP_ConsultaHash", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "hash1"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "hash2"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "hash3"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "hash4"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "hash5"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "hash6"), }, resultClasses = {
				OHashFirmaDocumento.class })
public class OHashFirmaDocumento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3565314679952565267L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "cargo")
	private String cargo;
	@Column(name = "codigo_dependencia")
	private String codigo_dependencia;
	@Column(name = "numero_radicado")
	private String numeroRadicado;
	@Column(name = "numero_borrador")
	private String numeroBorrador;
	@Column(name = "hash_1")
	private String hash1;
	@Column(name = "hash_2")
	private String hash2;
	@Column(name = "hash_3")
	private String hash3;
	@Column(name = "hash_4")
	private String hash4;
	@Column(name = "hash_5")
	private String hash5;
	@Column(name = "hash_6")
	private String hash6;

	@Column(name = "fecha_creacion")
	private Instant fechaCreacion;

	@Column(name = "estado")
	private Boolean estado;

	@PrePersist
	private void prePersistFunction() {

		ZoneId zoneId = ZoneId.of("America/Bogota");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
		Instant instant = zonedDateTime.toInstant();
		this.fechaCreacion = instant;
	}
}
