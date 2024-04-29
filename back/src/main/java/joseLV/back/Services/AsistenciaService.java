package joseLV.back.Services;

import joseLV.back.Entities.AsistenciaEntity;
import joseLV.back.Repositories.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaService {
    @Autowired
    AsistenciaRepository asistenciaRepository;

    public AsistenciaEntity guardar(AsistenciaEntity registro ){
        return asistenciaRepository.save(registro);
    }
}
