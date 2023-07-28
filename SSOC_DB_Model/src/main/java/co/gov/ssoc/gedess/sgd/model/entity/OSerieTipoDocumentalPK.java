package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OSerieTipoDocumentalPK implements Serializable {

	private static final long serialVersionUID = 1189289L;

	@ManyToOne
	@JoinColumn(name = "tipo_documental_id")
	private OTipoDocumental tipoDocumental;

	@ManyToOne
	@JoinColumn(name = "serie_id")
	private OSerie serie;

	@ManyToOne
	@JoinColumn(name = "trd_id")
	private OTablaRetencionDocumental trd;

}