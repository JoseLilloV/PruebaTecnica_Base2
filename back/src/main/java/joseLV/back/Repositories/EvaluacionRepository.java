package joseLV.back.Repositories;

import joseLV.back.Entities.EvaluacionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionRepository extends CrudRepository<EvaluacionEntity, Long> {
}
