package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "Plantillas_Filenet", schema="Administracion")
public class OPlantillaFilenet implements Serializable {

	private static final long serialVersionUID = 2909L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "Id_Plantilla_Filenet")
	private String idPlantillaFilenet;

	@Column(name = "Nombre_Simbolico_Plantilla_Filenet")
	private String nombreSimbolicoPlantillaFilenet;
	
	@Column(name = "Nombre_Plantilla")
	private String nombrePlantilla;
	
	@Column(name = "Version")
	private Integer version;
	
	@ManyToOne
    @JoinColumn(name="Id_Tramite")
	private OTramite tramite;
}