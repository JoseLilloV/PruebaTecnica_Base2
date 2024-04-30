package joseLV.back.Services.strategy;

import com.google.gson.*;


import joseLV.back.Entities.*;
import joseLV.back.Services.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class JsonReader implements ReaderStrategy{

    @Override
    public void reader(String stream,
                       AsistenciaService asistenciaService,
                       EstudianteService estudianteService,
                       AsignaturaService asignaturaService,
                       CursoService cursoService,
                       InscripcionService inscripcionService) throws IOException, ParseException {
        if (!stream.isEmpty()) {
            SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");

            String content = stream;
           // final Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonArray gsonArr = parser.parse(content).getAsJsonArray();

            for (JsonElement obj : gsonArr) {
                JsonObject gsonObj = obj.getAsJsonObject();
                //System.out.println(gsonObj);

                AsistenciaEntity asistenciaTemp = new AsistenciaEntity();
                asistenciaTemp.setFecha(formato.parse(gsonObj.get("fecha").getAsString()));
                Optional<AsignaturaEntity>  asignaturaTemp = asignaturaService.findActiveByCodigo(gsonObj.get("codigo").getAsString());
                if ( asignaturaTemp.isPresent()) {
                    Optional<CursoEntity> cursoTemp = cursoService.findActiveByAsignaturaIdAndSeccion(asignaturaTemp.get().getId(), Integer.valueOf(gsonObj.get("seccion").getAsString()));
                    if(cursoTemp.isPresent()) {
                        Optional<EstudianteEntity> estudianteTemp = estudianteService.findActiveByRut(gsonObj.get("rut").getAsString());
                        if(estudianteTemp.isPresent()) {
                            Optional<InscripcionEntity> inscripcionTemp = inscripcionService.findActiveByEstudianteIdAndCursoIdAndSemestre(estudianteTemp.get().getId(), cursoTemp.get().getId(), gsonObj.get("semestre").getAsString());
                            if(inscripcionTemp.isPresent()) {
                                asistenciaTemp.setInscripcion(inscripcionTemp.get());
                                if (gsonObj.get("asistencia").getAsString().equals("0") ) {
                                    asistenciaTemp.setAsistencia(Boolean.FALSE);
                                } else {
                                    asistenciaTemp.setAsistencia(Boolean.TRUE);
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
