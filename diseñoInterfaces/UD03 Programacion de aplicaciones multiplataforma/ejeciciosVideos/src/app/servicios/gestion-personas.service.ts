import { Injectable } from '@angular/core';

export interface IPersona {
  id: string;
  nombre: string;
  apellido: string;
}

@Injectable({
  providedIn: 'root',
})
export class GestionPersonasService {
  personas: IPersona[] = [
    {
      id: 'aa',
      nombre: 'Aitor',
      apellido: 'Arana',
    },
    {
      id: 'sr',
      nombre: 'Sara',
      apellido: 'Ruiz',
    },
    {
      id: 'mo',
      nombre: 'Miren',
      apellido: 'Ojer',
    },
  ];

  constructor() {}
}
