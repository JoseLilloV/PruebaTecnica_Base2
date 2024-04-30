import { Component } from '@angular/core';
import { AsistenciaService } from '../services/asistencia.service'; 


@Component({
  selector: 'app-tabla-asistencia',
  standalone: true,
  imports: [],
  templateUrl: './tabla-asistencia.component.html',
  styleUrl: './tabla-asistencia.component.css'
})
export class TablaAsistenciaComponent { 
  
  asistencias: any[] = [];

  constructor(private asistenciaService: AsistenciaService) { } 

  ngOnInit(): void {
    this.asistenciaService.ObtenerTodaAsistencia().subscribe(data => {
      this.asistencias = data;
      console.log(this.asistencias)
    });
  }
  
  formatDate(dateString: string): string {
    const date = new Date(dateString);
    return date.toISOString().split('T')[0];
  }
  


}
