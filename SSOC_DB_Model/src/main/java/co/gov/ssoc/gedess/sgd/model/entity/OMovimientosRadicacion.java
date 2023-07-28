package co.gov.ssoc.gedess.sgd.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "Movimientos_Radicacion", schema="correspondencia")
public class OMovimientosRadicacion implements Serializable {
    private static final long serialVersionUID = 868732655910366L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@ManyToOne
	@JoinColumn(name = "id_radicado")
	private ORadicacion radicacion;
	
    private String sender_identification_number;
    
    private String last_assigned_dependency_id;
    private String last_assigned_user_id;
    
    private String assigned_dependency_id;
    private String assigned_user_id;
    private String subject;
	
	@Column(name = "date_movimiento")
	private Date dateMovimiento;
    
    @PrePersist
	private void prePersistFunction() {
		this.dateMovimiento = new Date();
	}

}
