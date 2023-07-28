package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
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
public class OTramitesDependenciaPK implements Serializable {

	private static final long serialVersionUID = 1189289L;

	@Column(name = "codigoGrupoTrabjo")
	private Integer codigoGrupoTrabajo;
	
	@Column(name = "nombreGrupoTrabjo")
	private String nombreGrupoTrabajo;
	
	@ManyToOne
    @JoinColumn(name="IdTramite")
	private OTramite tramite;

}