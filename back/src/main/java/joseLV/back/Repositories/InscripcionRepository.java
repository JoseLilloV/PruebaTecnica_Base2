package joseLV.back.Repositories;

import joseLV.back.Entities.InscripcionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends CrudRepository<InscripcionEntity, Long> {
}
