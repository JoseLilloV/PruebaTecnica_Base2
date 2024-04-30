import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-cargar-archivo',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './cargar-archivo.component.html',
  styleUrl: './cargar-archivo.component.css'
})
export class CargarArchivoComponent {
  constructor() { }

  onFileSelected(event: any) {
    const file: File = event.target.files[0];
    const reader: FileReader = new FileReader();

    reader.onload = (e) => {
      const fileContent: string = reader.result as string;
      console.log(fileContent); 
    };

    reader.readAsText(file);
  }
}
