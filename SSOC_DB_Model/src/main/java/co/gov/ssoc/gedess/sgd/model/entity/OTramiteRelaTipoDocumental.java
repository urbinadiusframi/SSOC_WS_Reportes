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
@Table(name = "TramiteTipoDocumental", schema="Administracion")
public class OTramiteRelaTipoDocumental implements Serializable {

	private static final long serialVersionUID = 1181261280392L;
	
	@EmbeddedId
    private OTramiteTipoDocumentalPK tramiteTipoDocumental;

}