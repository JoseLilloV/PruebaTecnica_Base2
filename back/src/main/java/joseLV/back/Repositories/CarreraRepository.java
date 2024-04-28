package joseLV.back.Repositories;

import joseLV.back.Entities.CarreraEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<CarreraEntity, Long> {
}
