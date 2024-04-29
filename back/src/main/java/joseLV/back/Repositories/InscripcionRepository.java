package joseLV.back.Repositories;

import joseLV.back.Entities.EstudianteEntity;
import joseLV.back.Entities.InscripcionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InscripcionRepository extends CrudRepository<InscripcionEntity, Long> {
     Optional<InscripcionEntity> findByEstudianteIdAndCursoIdAndSemestre(Long estudianteId, Long cursoId, String semestre);
}
