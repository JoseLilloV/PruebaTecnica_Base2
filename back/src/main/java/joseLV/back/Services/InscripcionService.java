package joseLV.back.Services;

import joseLV.back.Entities.InscripcionEntity;
import joseLV.back.Repositories.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InscripcionService {
    @Autowired
    InscripcionRepository inscripcionRepository;

    public Optional<InscripcionEntity> findActiveByEstudianteIdAndCursoIdAndSemestre(Long estudianteId, Long cursoId, String semestre){
        return inscripcionRepository.findByEstudianteIdAndCursoIdAndSemestre(estudianteId, cursoId,semestre);
    }



}
