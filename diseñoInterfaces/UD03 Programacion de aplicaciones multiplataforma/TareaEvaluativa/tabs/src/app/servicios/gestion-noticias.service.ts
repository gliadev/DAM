import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GestionNoticiasService {

  constructor(private leerFichero: HttpClient) { }

  getArticulos(){
    let datosFicheros: Observable<[Articles]>
  }
}
