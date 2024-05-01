import { ComponentFixture, TestBed } from '@angular/core/testing';1
import { TablaAsistenciaComponent } from './tabla-asistencia.component';
import { AsistenciaService } from '../services/asistencia.service';
import { of } from 'rxjs';

describe('TablaAsistenciaComponent', () => {
  let component: TablaAsistenciaComponent;
  let fixture: ComponentFixture<TablaAsistenciaComponent>;
  let mockAsistenciaService: jasmine.SpyObj<AsistenciaService>;

  beforeEach(async () => {
    mockAsistenciaService = jasmine.createSpyObj('AsistenciaService', ['ObtenerTodaAsistencia']);

    await TestBed.configureTestingModule({
      imports: [],
      providers: [
        { provide: AsistenciaService, useValue: mockAsistenciaService }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TablaAsistenciaComponent);
    component = fixture.componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call ObtenerTodaAsistencia and populate asistencias array on ngOnInit', () => {
    const mockData = [
      {
        fecha: '2024-04-30T12:00:00Z',
        inscripcion: {
          estudiante: {
            nombres: 'Juan',
            apellido_paterno: 'Pérez',
            apellido_materno: 'González',
            rut: '12345678-9'
          },
          curso: {
            asignatura: {
              nombre: 'Matemáticas'
            },
            seccion: 'A'
          }
        },
        asistencia: true
      }
    ];

    mockAsistenciaService.ObtenerTodaAsistencia.and.returnValue(of(mockData));

    fixture.detectChanges();
    expect(mockAsistenciaService.ObtenerTodaAsistencia).toHaveBeenCalled();
    expect(component.asistencias).toEqual(mockData);
  });

  it('should format date correctly', () => {
    const formattedDate = component.formatDate('2024-04-30T12:00:00Z');
    expect(formattedDate).toBe('2024-04-30');
  });
});
