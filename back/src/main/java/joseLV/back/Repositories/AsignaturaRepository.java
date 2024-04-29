package joseLV.back.Repositories;

import joseLV.back.Entities.AsignaturaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AsignaturaRepository extends CrudRepository<AsignaturaEntity, Long> {

    Optional<AsignaturaEntity> findByCodigo(String codigo);
}
