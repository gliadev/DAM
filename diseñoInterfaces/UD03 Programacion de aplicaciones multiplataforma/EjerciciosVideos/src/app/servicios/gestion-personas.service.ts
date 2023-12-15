import { InsertarPage } from './../pages/insertar/insertar.page';
import { Injectable } from '@angular/core';

export interface IPersona {
  id: string;
  nombre: string;
  apellido: string;
}

@Injectable({
  providedIn: 'root'
})
export class GestionPersonasService {
  private personas: IPersona[] = [
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
  constructor() { }

  // metodo para devolver los datos para poderlo leerlos desde la hombepage

  getPersonas() {
    return this.personas;
  }

  // insertamos una nueva persona
  InsertarPersonas(id: string, nombre: string, apellido: string ) {

    // creamos la persona
    let nuevaPersona: IPersona = {
      id: id,
      nombre: nombre,
      apellido: apellido
    };

    // la insertamos
    this.personas.push(nuevaPersona);
    console.log(this.personas)

    this.personas = [...this.personas, nuevaPersona]

  }
  // Borra la persona con el id dado
  borrarPersona(id: string) {

  // Busca la persona con el id dado. Utiliza una función anónima como parámetro
  let personaEncontrada: IPersona = this.personas.find(function(cadaPersona) { return cadaPersona.id == id });

  // Busca la persona con el id dado. Utiliza una función arrow como parámetro
  // let personaEncontrada: IPersona = this.personas.find((cadaPersona) => cadaPersona.id == id);

  console.log(personaEncontrada);

  // Busca el índice de la persona
  let indice: number = this.personas.indexOf(personaEncontrada);
  console.log(indice);

  if (personaEncontrada) {
    if (indice != -1){
      // Borra la persona con el índice obtenido
    this.personas.splice(indice, 1);

    // Genera un nuevo array sin el elemento a borrar y lo asigna
    // let inicio = this.personas.slice(0, indice);             // Copia primera parte del array
    // let final= this.personas.slice(indice + 1);              // Copia la parte final
    // this.personas = [...inicio, ...final];                   // Añade todos los elementos copiados

    console.log(this.personas);
      }
    }
  }

  modificarPersona(id: string, nombre: string, apellido: string){
    // buscamos la persona con el id dado. utilizamos una funcion anonima como parametro
    let personaEncontrada: IPersona = this.personas.find(function(cadaPersona) {return cadaPersona.id == id })

    // buscamos el indice para modificar ese elemento
    let indice: number = this.personas.indexOf(personaEncontrada)

    // cuando ya tenemso el indice lo modificamos
    this.personas[indice].nombre = nombre;
    this.personas[indice].apellido = apellido
  }

}








