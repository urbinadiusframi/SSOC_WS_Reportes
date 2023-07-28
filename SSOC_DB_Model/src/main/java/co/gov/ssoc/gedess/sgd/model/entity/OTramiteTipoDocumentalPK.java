package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OTramiteTipoDocumentalPK implements Serializable {

	private static final long serialVersionUID = 1189289L;

	@ManyToOne
    @JoinColumn(name="IdTipoDocumental")
	private OTipoDocumental tipoDocumental;
	
	@ManyToOne
    @JoinColumn(name="IdTramite")
	private OTramite tramite;

}