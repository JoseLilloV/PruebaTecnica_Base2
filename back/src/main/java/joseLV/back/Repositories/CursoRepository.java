package joseLV.back.Repositories;

import joseLV.back.Entities.CursoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<CursoEntity, Long> {
}
