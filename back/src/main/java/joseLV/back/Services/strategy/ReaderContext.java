package joseLV.back.Services.strategy;


import joseLV.back.Services.*;

import java.io.IOException;
import java.text.ParseException;

public class ReaderContext {

    private ReaderStrategy strategy;

    public void setReaderMethod(ReaderStrategy strategy){
        this.strategy = strategy;
    }
    public ReaderStrategy getStrategy(){
        return this.strategy;
    }
    public void readerFile(String stream,
                           AsistenciaService asistenciaService,
                           EstudianteService estudianteService,
                           AsignaturaService asignaturaService,
                           CursoService cursoService,
                           InscripcionService inscripcionService) throws IOException, ParseException {
        this.strategy.reader(stream, asistenciaService,estudianteService, asignaturaService, cursoService, inscripcionService);
    }
}
