package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "Estados_Transicion_Radicacion", schema="correspondencia")
public class OEstadosTransicionRadicacion implements Serializable {

	private static final long serialVersionUID = 18126L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	@ManyToOne
    @JoinColumn(name = "id_radicado")
	private ORadicacion radicacion;
	@ManyToOne
    @JoinColumn(name = "id_estado")
	private OEstadoRadicacion estadoRadicacion;
	private String author;
	@Column(name = "transition_date")
	private Date transitionDate;
	@Column(name = "transition_observation")
	private String transitionObservation;

	@PrePersist
	private void prePersistFunction() {
		this.transitionDate = new Date();
	}
}