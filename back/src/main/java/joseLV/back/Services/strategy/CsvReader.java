package joseLV.back.Services.strategy;

import joseLV.back.Entities.*;
import joseLV.back.Services.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;



public class CsvReader implements ReaderStrategy{

    @Override

    public void reader(String stream, AsistenciaService asistenciaService,
                       EstudianteService estudianteService,
                       AsignaturaService asignaturaService,
                       CursoService cursoService,
                       InscripcionService inscripcionService) throws IOException, ParseException {

        if (!stream.isEmpty()) {
            SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
            String content = stream;
            String[] lineas = content.split("\n");
            String[] registro;
            for (int i = 1; i < lineas.length; i++) {
                registro = lineas[i].split(";");
                AsistenciaEntity asistenciaTemp = new AsistenciaEntity();
                asistenciaTemp.setFecha(formato.parse(registro[0]));
                Optional<AsignaturaEntity> asignaturaTemp = asignaturaService.findActiveByCodigo(registro[2]);
                if ( asignaturaTemp.isPresent()) {
                    Optional<CursoEntity>  cursoTemp = cursoService.findActiveByAsignaturaIdAndSeccion(asignaturaTemp.get().getId(), Integer.valueOf(registro[3]));
                    if(cursoTemp.isPresent()) {
                        Optional<EstudianteEntity> estudianteTemp = estudianteService.findActiveByRut(registro[4]);
                        if(estudianteTemp.isPresent()) {
                            Optional<InscripcionEntity> inscripcionTemp = inscripcionService.findActiveByEstudianteIdAndCursoIdAndSemestre(estudianteTemp.get().getId(), cursoTemp.get().getId(), registro[1]);
                            if(inscripcionTemp.isPresent()) {
                                asistenciaTemp.setInscripcion(inscripcionTemp.get());
                                if (registro[5].charAt(0) == '1') {
                                    asistenciaTemp.setAsistencia(Boolean.TRUE);
                                } else {
                                    asistenciaTemp.setAsistencia(Boolean.FALSE);
                                }
                                asistenciaService.guardar(asistenciaTemp);
                            }
                        }
                    }
                }
            }
        }

    }
}
