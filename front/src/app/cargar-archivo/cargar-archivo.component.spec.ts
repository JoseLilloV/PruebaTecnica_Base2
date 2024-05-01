import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CargarArchivoComponent } from './cargar-archivo.component';
import { AsistenciaService } from '../services/asistencia.service';
import { of } from 'rxjs';

describe('CargarArchivoComponent', () => {
  let component: CargarArchivoComponent;
  let fixture: ComponentFixture<CargarArchivoComponent>;
  let asistenciaService: jasmine.SpyObj<AsistenciaService>;

  beforeEach(async () => {
    const asistenciaServiceSpy = jasmine.createSpyObj('AsistenciaService', ['CargaArchivoAsistencia']);

    await TestBed.configureTestingModule({
      imports: [],
      providers: [{ provide: AsistenciaService, useValue: asistenciaServiceSpy }]
    }).compileComponents();

    asistenciaService = TestBed.inject(AsistenciaService) as jasmine.SpyObj<AsistenciaService>;
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CargarArchivoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call AsistenciaService.CargaArchivoAsistencia when cargarArchivo is called', () => {
    const fileContent = 'Test file content';
    const fileName = 'test_file.txt';

    component.fileName = fileName;
    component.fileContent = fileContent;

    asistenciaService.CargaArchivoAsistencia.and.returnValue(of({}));

    component.cargarArchivo();

    expect(asistenciaService.CargaArchivoAsistencia).toHaveBeenCalledWith(fileName, fileContent);
  });

  // Add more test cases as needed
});
