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
@Table(name = "TradicionDocumental", schema="Administracion")
public class OTradicionDocumental implements Serializable{
	
	private static final long serialVersionUID = 1571414323092176522L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}
