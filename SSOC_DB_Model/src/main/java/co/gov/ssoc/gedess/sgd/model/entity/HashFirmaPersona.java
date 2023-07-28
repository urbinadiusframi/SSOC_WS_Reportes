package co.gov.ssoc.gedess.sgd.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
//@org.hibernate.envers.Audited
@Table(name = "Hash_Firma_Personas",schema = "correspondencia")
@Data
public class HashFirmaPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_hash_firma_documento", nullable = false)
    private OHashFirmaDocumento idHashFirmaDocumento;

    @Column(name = "tipo_persona", nullable = false, length = 100)
    private String tipoPersona;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "cargo", nullable = false, length = 100)
    private String cargo;

    @Column(name = "codigo_dependencia", nullable = false, length = 100)
    private String codigoDependencia;

    @Column(name = "fecha_cargue")
    private Instant fechaCargue;


    @PrePersist
    private void prePersistFunction() {

        ZoneId zoneId = ZoneId.of("America/Bogota");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
        Instant instant = zonedDateTime.toInstant();
        this.fechaCargue =  instant;
    }
}