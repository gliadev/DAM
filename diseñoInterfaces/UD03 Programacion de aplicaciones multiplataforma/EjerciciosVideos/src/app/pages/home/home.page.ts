import { Component } from '@angular/core';
import { GestionPersonasService } from 'src/app/servicios/gestion-personas.service';




@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

// los contructrores tienen que usar ese servicio
  constructor( public gestionPersonas: GestionPersonasService) {}



}
