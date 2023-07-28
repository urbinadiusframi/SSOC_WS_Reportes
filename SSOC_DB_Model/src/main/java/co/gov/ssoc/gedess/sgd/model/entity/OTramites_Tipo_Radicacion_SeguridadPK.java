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
public class OTramites_Tipo_Radicacion_SeguridadPK implements Serializable {

	private static final long serialVersionUID = 1189289L;

	@ManyToOne
    @JoinColumn(name="id_tipo_radicacion")
	private OTipoRadicacion tipoRadicacion;
	
	@ManyToOne
    @JoinColumn(name="id_tipo_seguridad")
	private OTipoSeguridad tipoSeguridad;	
	
	@ManyToOne
    @JoinColumn(name="id_tramite")
	private OTramite tramite;

}