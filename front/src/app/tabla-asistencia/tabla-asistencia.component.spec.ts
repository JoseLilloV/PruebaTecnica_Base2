import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaAsistenciaComponent } from './tabla-asistencia.component';

describe('TablaAsistenciaComponent', () => {
  let component: TablaAsistenciaComponent;
  let fixture: ComponentFixture<TablaAsistenciaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TablaAsistenciaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TablaAsistenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
