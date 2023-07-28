package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "TiposDocumentalSoporte", schema="Administracion")
public class OTipoDocumentalSoporte implements Serializable{

	private static final long serialVersionUID = 112216L;
	@EmbeddedId
    private OTipoDocumentalSoportePK tipoDocumentalSoportePK;

}