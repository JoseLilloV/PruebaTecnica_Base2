package joseLV.back.Services;

import joseLV.back.Entities.EstudianteEntity;
import joseLV.back.Repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    public Optional<EstudianteEntity> findActiveByRut(String rut){
        return estudianteRepository.findByRut(rut);
    }
}
