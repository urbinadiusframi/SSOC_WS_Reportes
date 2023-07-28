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
public class OTrdDisposicionFinalPK implements Serializable {

	private static final long serialVersionUID = 1189289L;

	@ManyToOne
    @JoinColumn(name="IdDisposicionFinal")
	private ODisposicionFinal disposionFinal;
	
	@ManyToOne
    @JoinColumn(name="IdTRD")
	private OTablaRetencionDocumental trd;	
}