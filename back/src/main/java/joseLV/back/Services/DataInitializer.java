package joseLV.back.Services;

import jakarta.annotation.PostConstruct;
import joseLV.back.Entities.*;
import joseLV.back.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class DataInitializer {
    @Autowired
    private CarreraRepository carreraRepository;
    @Autowired
    private AsignaturaRepository asignaturaRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private InscripcionRepository inscripcionRepository;

    @PostConstruct
    public void initData() {
        Random rand = new Random();
        int cantidad = 3;
        if (carreraRepository.count() == 0) {
            for (int i = 1; i <= cantidad; i++) {
                CarreraEntity nuevaCarrera = new CarreraEntity();
                nuevaCarrera.setNombre("Carrera_" + i);
                carreraRepository.save(nuevaCarrera);

            }
        }
        List<CarreraEntity> carreras = (List<CarreraEntity>) carreraRepository.findAll();
        if (asignaturaRepository.count() == 0) {
            for (int i = 1; i <= cantidad; i++) {
                AsignaturaEntity asignaturaNueva = new AsignaturaEntity();
                asignaturaNueva.setNombre("Asignatura_" + i);
                asignaturaNueva.setCodigo("eg-" + i);
                asignaturaNueva.setCarrera(carreras.get(rand.nextInt(cantidad)));
                asignaturaRepository.save(asignaturaNueva);

            }
        }
        if (estudianteRepository.count() == 0) {
            for (int i = 1; i <= cantidad; i++) {
                EstudianteEntity estudianteNuevo = new EstudianteEntity();
                estudianteNuevo.setNombres("Estudiante_" + i);
                estudianteNuevo.setRut(i + "-" + i);
                estudianteNuevo.setApellido_paterno("Apellido_" + i);
                estudianteNuevo.setApellido_materno("Apellido_" + i);
                estudianteNuevo.setCarrera(carreras.get(rand.nextInt(cantidad)));
                estudianteRepository.save(estudianteNuevo);
            }
        }

        if (cursoRepository.count() == 0) {
            for (int i = 1; i <= cantidad; i++) {
                CursoEntity cursoNuevo = new CursoEntity();
                cursoNuevo.setHorario("L4W4V4");
                cursoNuevo.setSeccion(1);
                cursoNuevo.setAsignatura(new AsignaturaEntity());
                cursoNuevo.getAsignatura().setId((long) i);
                cursoRepository.save(cursoNuevo);
            }
        }
        if (inscripcionRepository.count() == 0) {
            for (int i = 1; i <= cantidad; i++) {
                for( int j = 1; j <= cantidad; j++) {
                    InscripcionEntity inscripcionNueva = new InscripcionEntity();
                    inscripcionNueva.setCurso( new CursoEntity());
                    inscripcionNueva.getCurso().setId((long) i);
                    inscripcionNueva.setEstudiante(new EstudianteEntity());
                    inscripcionNueva.getEstudiante().setId((long) j);
                    inscripcionNueva.setSemestre("2024-1");
                    inscripcionRepository.save(inscripcionNueva);
                }
            }
        }

    }
}