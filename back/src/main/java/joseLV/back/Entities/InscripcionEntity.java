package joseLV.back.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "inscripcion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InscripcionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private EstudianteEntity estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoEntity curso;

    private String semestre;
}
