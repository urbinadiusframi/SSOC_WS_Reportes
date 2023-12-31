package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "Estados_Radicacion", schema="correspondencia")
public class OEstadoRadicacion implements Serializable {

	private static final long serialVersionUID = 18126L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String codigo;
	private String nombre;
	private Boolean estado;

}