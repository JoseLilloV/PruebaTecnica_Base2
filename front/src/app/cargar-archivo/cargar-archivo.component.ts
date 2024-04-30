import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { AsistenciaService } from '../services/asistencia.service'; 

@Component({
  selector: 'app-cargar-archivo',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './cargar-archivo.component.html',
  styleUrl: './cargar-archivo.component.css'
})
export class CargarArchivoComponent {

  fileContent: string = '';
  fileName: string = '';

  constructor(private asistenciaService: AsistenciaService) { } 

  onFileSelected(event: any) {
    const file: File = event.target.files[0];
    const reader: FileReader = new FileReader();

    reader.onload = (e) => {
      this.fileContent = reader.result as string;
      this.fileName = file.name;
    };

    reader.readAsText(file);
  }
  cargarArchivo(): void {
    this.asistenciaService.CargaArchivoAsistencia(this.fileName, this.fileContent).subscribe(response => {
      console.log('Data created successfully:', response);
      this.fileContent = ''; 
      this.fileName = ''; 
      alert("Archivo subido corectamente! :)");
    }, errorResponse => {
      if (errorResponse.status === 200) {
        console.log('Data created successfully:', errorResponse);
        this.fileContent = ''; 
        this.fileName = ''; 
        alert("Archivo subido correctamente! :)");
      } else {
        console.error('Error creating data:', errorResponse);
        alert("Ocurrió un error al subir el archivo :(");
      }
    });
  }
}
