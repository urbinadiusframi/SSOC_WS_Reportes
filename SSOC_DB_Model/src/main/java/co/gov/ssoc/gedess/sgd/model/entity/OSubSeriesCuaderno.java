package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Builder
@Table(name = "SubSerieCuaderno", schema="Administracion")
public class OSubSeriesCuaderno implements Serializable{

	private static final long serialVersionUID = 112216L;
	@EmbeddedId
    private OSubSeriesCuadernoPK serieCuadernoPK;

}