package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;

import javax.persistence.*;

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
@Table(name = "Tramites_Tipo_Radicacion_Seguridad", schema="correspondencia")
public class OTramites_Tipo_Radicacion_Seguridad implements Serializable {

	private static final long serialVersionUID = 11892L;
	@EmbeddedId
    private OTramites_Tipo_Radicacion_SeguridadPK tramiteRadSeg;



}