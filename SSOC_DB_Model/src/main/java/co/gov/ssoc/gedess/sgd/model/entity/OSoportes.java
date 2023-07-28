package co.gov.ssoc.gedess.sgd.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "Soportes", schema="Administracion")
public class OSoportes implements Serializable{
  
	private static final long serialVersionUID = 87651L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column (name ="NombreMedio", unique = true)
    private String nombreMedio;
}
