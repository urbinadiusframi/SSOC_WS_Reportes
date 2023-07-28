package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "Tramites_Tipo_Radicacion", schema="correspondencia")
public class OTramites_Tipo_Radicacion implements Serializable {

	private static final long serialVersionUID = 11892L;
	
	@EmbeddedId
    private OTramites_Tipo_Radicacion_PK tramiteTipoRadic;

}