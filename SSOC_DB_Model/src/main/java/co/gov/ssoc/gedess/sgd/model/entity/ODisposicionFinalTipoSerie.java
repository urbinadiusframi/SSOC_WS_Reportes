package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "DisposicionFinalSerie", schema = "Administracion")
public class ODisposicionFinalTipoSerie implements Serializable {

	private static final long serialVersionUID = 112216L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "IdDisposicionFinal")
	private ODisposicionFinal disposionFinal;

	@ManyToOne
	@JoinColumn(name = "IdDisposicionFinalSerie")
	private ODisposicionFinalSerie disposicionFinalSerie;

}