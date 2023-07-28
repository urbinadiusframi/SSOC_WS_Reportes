package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
//@org.hibernate.envers.Audited
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Log_Firma_Digital", schema = "correspondencia")
public class OLogFirmaDigital implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@OneToOne
	@JoinColumn(name = "id_hash_firma_documento")
	private OHashFirmaDocumento metadatos;

	@Column(name = "fecha_cargue")
	private Date fechaCargue;
}
