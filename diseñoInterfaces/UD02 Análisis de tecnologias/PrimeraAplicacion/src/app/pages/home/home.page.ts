import { Component } from '@angular/core';

// Definición de la clase que maneja el nombre, el icono y el enlace de cada item de la lista
// Los atributos o propiedades son privados y necesitamos los getters y setters
class ClaseElemento {
  private nombre: string;
  private icono: string;
  private enlace: string;

  constructor(nombre: string,  icono: string, enlace: string) {
    this.nombre = nombre;
    this.icono = icono;
    this.enlace = enlace;
  }
    
  public getEnlace(): string {
    return this.enlace;
  }
  public setEnlace(value: string) {
    this.enlace = value;
  }

  public getIcono(): string {
    return this.icono;
  }
  public setIcono(value: string) {
    this.icono = value;
  }

  public getNombre(): string {
    return this.nombre;
  }
  public setNombre(value: string) {
    this.nombre = value;
  }
}

// Definición del nuevo tipo "TElemento" que almacena el nombre, el icono y el enlace de cada item de la lista
type TElemento = {
  nombre: string;
  icono: string;
  enlace: string;
}

// Definición de la nueva interface "IElemento" que almacena el nombre, el icono y el enlace de cada item de la lista
interface IElemento {
  nombre: string;
  icono: string;
  enlace: string;
}

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  // Creamos un array de Items. Pueden ser de tipo TElemento o una interfaz IElemento
  valoresLista: IElemento[] = [
    {
      nombre: "Item 1",
      icono: "alarm-outline",
      enlace: "/pagina1"
    },
    {
      nombre: "Item 2",
      icono: "balloon-outline",
      enlace: "/pagina2"
    },
    {
      nombre: "Item 3",
      icono: "car-outline",
      enlace: "/home"
    }
  ];

  // Creamos un array de objetos de la clase ClaseElemento. Debemos usar new para instanciar cada objeto
  listaObjetos: ClaseElemento[] = [
    new ClaseElemento("Item 1", "alarm-outline","/pagina1"),
    new ClaseElemento("Item 2", "balloon-outline","/pagina2"),
    new ClaseElemento("Item 3", "car-outline","/home")
  ];

  constructor() {}

}
