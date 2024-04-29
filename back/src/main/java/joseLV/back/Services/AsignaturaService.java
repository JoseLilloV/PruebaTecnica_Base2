package joseLV.back.Services;

import joseLV.back.Entities.AsignaturaEntity;
import joseLV.back.Repositories.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AsignaturaService {
    @Autowired
    AsignaturaRepository asignaturaRepository;

    public Optional<AsignaturaEntity> findActiveByCodigo(String codigo){
        return asignaturaRepository.findByCodigo(codigo);
    }

}
