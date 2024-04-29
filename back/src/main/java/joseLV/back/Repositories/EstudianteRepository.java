package joseLV.back.Repositories;

import joseLV.back.Entities.EstudianteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteEntity, Long> {

    Optional<EstudianteEntity> findByRut(String rut);

}
