package joseLV.back.Controllers;

import joseLV.back.Entities.AsistenciaEntity;
import joseLV.back.Models.RequestModel;
import joseLV.back.Services.*;
import joseLV.back.Services.strategy.CsvReader;
import joseLV.back.Services.strategy.JsonReader;
import joseLV.back.Services.strategy.ReaderContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/Asistencia")
public class AsistenciaController {

    @Autowired
    AsistenciaService asistenciaService;
    @Autowired
    private AsignaturaService asignaturaService;
    @Autowired
    private EstudianteService estudianteService;
    @Autowired
    private CursoService cursoService;
    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping("/CargarArchivo")
    public ResponseEntity<String> carga(@RequestBody RequestModel registro) {
        ReaderContext context = new ReaderContext();
        try {
            switch (registro.getNombre()) {
                case "asistencia.txt":
                    context.setReaderMethod(new CsvReader());
                    context.readerFile(registro.getStream(), asistenciaService, estudianteService, asignaturaService, cursoService, inscripcionService);
                    break;
                case "asistencia.json":
                    context.setReaderMethod(new JsonReader());
                    context.readerFile(registro.getStream(), asistenciaService, estudianteService, asignaturaService, cursoService, inscripcionService);
                    break;
                default:
                    return ResponseEntity.badRequest().body("El tipo de archivo no es compatible.");
            }
            return ResponseEntity.ok("Archivo del Asistencia cargado correctamente");
        } catch (IOException | ParseException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar el archivo: " + e.getMessage());
        }
    }

    @GetMapping("/GetAll")
    public ResponseEntity<?> getAll() {
        try {
            Iterable<AsistenciaEntity> asistencias = asistenciaService.getAll();
            return ResponseEntity.ok(asistencias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener todas las asistencias: " + e.getMessage());
        }
    }


}
