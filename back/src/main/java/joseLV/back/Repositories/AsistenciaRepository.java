package joseLV.back.Repositories;

import joseLV.back.Entities.AsistenciaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends CrudRepository<AsistenciaEntity, Long> {
}
