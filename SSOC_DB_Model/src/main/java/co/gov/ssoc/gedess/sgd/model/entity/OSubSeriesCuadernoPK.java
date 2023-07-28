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
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
public class OSubSeriesCuadernoPK implements Serializable {

	private static final long serialVersionUID = 1189289L;

	@ManyToOne
    @JoinColumn(name="IdCuaderno")
	private OTipoCuaderno cuaderno;
	
	@ManyToOne
    @JoinColumn(name="IdSubSerie")
	private OSubSerie subserie;	
}