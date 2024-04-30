import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
//import { RequestModel } from './request-model';

@Injectable({
  providedIn: 'root'
})
export class AsistenciaService {

  private baseUrl = 'http://localhost:8080/'; 
  
  constructor(private http: HttpClient) { }

  CargaArchivoAsistencia(nombreArchivo: string, stream: string): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}Asistencia/CargarArchivo`, {stream: stream, nombre: nombreArchivo})
  }

  //getData(): Observable<any> {
    //return this.http.get<any>(`${this.baseUrl}/data`); // Endpoint de la API en tu backend
  //}
  
}
