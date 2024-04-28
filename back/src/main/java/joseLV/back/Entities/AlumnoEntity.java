package joseLV.back.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "alumno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String rut;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrera_id", referencedColumnName = "id")
    private CarreraEntity carrera;


}
