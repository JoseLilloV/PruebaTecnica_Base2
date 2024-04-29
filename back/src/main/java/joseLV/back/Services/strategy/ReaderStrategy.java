package joseLV.back.Services.strategy;


import joseLV.back.Services.*;

import java.io.IOException;
import java.text.ParseException;

public interface ReaderStrategy {

    public void reader(String steam,
                       AsistenciaService asistenciaService,
                       EstudianteService estudianteService,
                       AsignaturaService asignaturaService,
                       CursoService cursoService,
                       InscripcionService inscripcionService) throws IOException, ParseException;
}

