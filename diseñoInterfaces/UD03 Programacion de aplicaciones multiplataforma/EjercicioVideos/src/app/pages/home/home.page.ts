import { Component } from '@angular/core';

export interface IPersona {
  id: string;
  nombre: string;
  apellido: string;
}


@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  personas: IPersona[] = [
    {
      id: "aa",
      nombre: "Aitor",
      apellido: "Arana"
    },
    {
      id: "sr",
      nombre: "Sara",
      apellido: "Ruiz"
    },
    {
      id: "mo",
      nombre: "Miren",
      apellido: "Ojer"
    }
  ]

  constructor() {}

}
