package joseLV.back.Controllers;

import joseLV.back.Models.RequestModel;
import joseLV.back.Services.*;
import joseLV.back.Entities.AsistenciaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@AutoConfigureMockMvc
@SpringBootTest
public class AsistenciaControllerTests {

    @Mock
    private AsistenciaService asistenciaService;
    @Mock
    private AsignaturaService asignaturaService;
    @Mock
    private EstudianteService estudianteService;
    @Mock
    private CursoService cursoService;
    @Mock
    private InscripcionService inscripcionService;

    @InjectMocks
    private AsistenciaController asistenciaController;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll_Success() {
        // Arrange
        List<AsistenciaEntity> mockAsistencias = new ArrayList<>();
        mockAsistencias.add(new AsistenciaEntity());
        mockAsistencias.add(new AsistenciaEntity());

        when(asistenciaService.getAll()).thenReturn(mockAsistencias);

        // Act
        ResponseEntity<?> response = asistenciaController.getAll();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockAsistencias, response.getBody());
    }

    @Test
    public void testGetAll_Exception() {
        // Arrange
        when(asistenciaService.getAll()).thenThrow(new RuntimeException("Error de prueba"));

        // Act
        ResponseEntity<?> response = asistenciaController.getAll();

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error al obtener todas las asistencias: Error de prueba", response.getBody());
    }

    @Test
    public void testCarga_Csv_Success() throws IOException, ParseException {
        // Arrange
        RequestModel requestModel = new RequestModel();
        requestModel.setNombre("asistencia.txt");
        requestModel.setStream("fecha;semestre;codigo;seccion;rut;asistencia\n26/04/2024;2024-1;eg-1;1;1-1;1\n26/04/2024;2024-1;eg-1;1;2-2;1\n26/04/2024;2024-1;eg-1;1;3-3;0");

        // Mock del servicio de asistenciaService
        when(asistenciaService.getAll()).thenReturn(null);

        // Act
        ResponseEntity<String> response = asistenciaController.carga(requestModel);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Archivo del Asistencia cargado correctamente", response.getBody());
    }

    @Test
    public void testCarga_Json_Success() throws IOException, ParseException {
        // Arrange
        RequestModel requestModel = new RequestModel();
        requestModel.setNombre("asistencia.json");
        requestModel.setStream("[\r\n {\r\n \"fecha\": \"26/04/2024\",\r\n \"semestre\": \"2024-1\",\r\n \"codigo\":\"eg-2\",\n" +
                "\"seccion\": \"1\",\r\n \"rut\": \"1-1\",\r\n \"asistencia\": \"1\"\r\n },\r\n {\r\n \"fecha\": \"26/04/2024\",\r\n" +
                 " \"semestre\": \"2024-1\",\r\n \"codigo\": \"eg-2\",\r\n \"seccion\": \"1\",\r\n \"rut\": \"2-2\",\r\n" +
                        " \"asistencia\": \"0\"\r\n },\r\n {\r\n \"fecha\": \"26/04/2024\",\r\n \"semestre\": \"2024-1\",\r\n " +
                        "\"codigo\": \"eg-2\",\r\n \"seccion\": \"1\",\r\n \"rut\": \"3-3\",\r\n \"asistencia\": \"1\"\r\n }\r\n]\r\n");

        // Mock del servicio de asistenciaService
        when(asistenciaService.getAll()).thenReturn(null);

        // Act
        ResponseEntity<String> response = asistenciaController.carga(requestModel);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Archivo del Asistencia cargado correctamente", response.getBody());
    }

    @Test
    public void testCarga_UnsupportedFileType() throws IOException, ParseException {
        // Arrange
        RequestModel requestModel = new RequestModel();
        requestModel.setNombre("otro_formato.txt");
        requestModel.setStream("contenido del archivo");

        // Act
        ResponseEntity<String> response = asistenciaController.carga(requestModel);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("El tipo de archivo no es compatible.", response.getBody());
    }

    /*
    @Test
    public void testCarga_Exception() throws IOException, ParseException {
        // Arrange
        RequestModel requestModel = new RequestModel();
        requestModel.setNombre("asistencia.txt");
        requestModel.setStream("contenido del archivo CSV");

        // Mock del servicio de asistenciaService que arroja una excepción
        when(asistenciaService.getAll()).thenThrow(new RuntimeException("Error de prueba"));

        // Act
        ResponseEntity<String> response = asistenciaController.carga(requestModel);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error al procesar el archivo: Error de prueba", response.getBody());
    }

     */
}

