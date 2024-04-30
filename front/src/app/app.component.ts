import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { CargarArchivoComponent } from './cargar-archivo/cargar-archivo.component';
import { TablaAsistenciaComponent } from './tabla-asistencia/tabla-asistencia.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule,
    HttpClientModule, 
    RouterOutlet,
    CargarArchivoComponent, 
    TablaAsistenciaComponent ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front';
}
