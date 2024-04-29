package joseLV.back.Services;

import joseLV.back.Entities.CursoEntity;
import joseLV.back.Repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;

    public Optional<CursoEntity> findActiveByAsignaturaIdAndSeccion(Long asignaturaId, Integer seccion){
        return  cursoRepository.findByAsignaturaIdAndSeccion(asignaturaId, seccion);
    }
}
