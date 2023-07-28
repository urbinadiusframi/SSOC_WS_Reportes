package co.gov.ssoc.gedess.sgd.model.entity.audit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
//@Entity
//@RevisionEntity
//@org.hibernate.envers.Audited
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
//@Table(name = "Audit", schema = "AdministracionAudit")
public class OAudit 
//extends org.hibernate.envers.DefaultRevisionEntity
implements Serializable {
	private static final long serialVersionUID = 8530213963961662300L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_rev_generator")
//	@SequenceGenerator(name = "user_rev_generator", allocationSize = 10, sequenceName = "app_userrev_seq")
//	@RevisionNumber
//	private int id;
//
//	@RevisionTimestamp
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date date;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "usuarioId")
	private Long usuarioId;

	@Column(name = "aplicacion")
	private String aplicacion;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EAuditType tipo;

	@Column(name = "entidad")
	private String entidad;

	@Column(name = "identificador")
	private String identificador;

	@Column(name = "programa")
	private String programa;

	@Column(name = "componente")
	private String componente;

	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "maquina")
	private String maquina;

	@Column(columnDefinition = "nvarchar(max)")
	private String contenido;

	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String comprobacion;
//
//	@ElementCollection
//	@JoinTable(name = "REVCHANGES", joinColumns = @JoinColumn(name = "REV"))
//	@Column(name = "ENTITYNAME", insertable = false, updatable = false)
//	@ModifiedEntityNames
//	private Set<String> modifiedEntityNames = new HashSet<>();
}
