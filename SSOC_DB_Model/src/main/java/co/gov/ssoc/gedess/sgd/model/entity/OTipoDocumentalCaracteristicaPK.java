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
public class OTipoDocumentalCaracteristicaPK implements Serializable {

	private static final long serialVersionUID = 1189289L;

	@ManyToOne
    @JoinColumn(name="IdCaracteristicas")
	private OCaracteristicas caracteristica;
	
	@ManyToOne
    @JoinColumn(name="IdTipoDocumental")
	private OTipoDocumental tipoDocumental;	
}