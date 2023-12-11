import { Component, OnInit } from '@angular/core';
import { GestionPersonasService } from 'src/app/servicios/gestion-personas.service';

@Component({
  selector: 'app-borrar',
  templateUrl: './borrar.page.html',
  styleUrls: ['./borrar.page.scss'],
})
export class BorrarPage implements OnInit {
  indice: string;

  constructor(private personas: GestionPersonasService) { }

  ngOnInit() {
  }

  onClick() {
    // Borrar
    this.personas.borrarPersona(this.indice)
  }
}
