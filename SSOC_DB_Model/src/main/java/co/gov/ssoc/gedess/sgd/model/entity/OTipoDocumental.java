package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
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
@Table(name = "Tipos_Documentales", schema = "Administracion")
public class OTipoDocumental implements Serializable {

	private static final long serialVersionUID = 112L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	@Column(unique = true)
	private String nombre;
	private Boolean estado;

	@Column(name = "Nombre_Simbolico_Filenet")
	private String nombreSimbolicoFilenet;
	private String observaciones;

	@PrePersist
	private void prePersistFunction() {
		this.estado = true;
	}

}