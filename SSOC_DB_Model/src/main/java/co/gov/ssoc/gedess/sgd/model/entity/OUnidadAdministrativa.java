package co.gov.ssoc.gedess.sgd.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "UnidadAdministrativa", schema = "Administracion")
public class OUnidadAdministrativa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CodigoUnidadAdministrativa")
	private Integer codigoUnidadAdministrativa;

	@Column(name = "NombreUnidadAdministrativa")
	private String nombreUnidadAdministrativa;
}
