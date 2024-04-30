package joseLV.back.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "asignatura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AsignaturaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String codigo;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private CarreraEntity carrera;

}
