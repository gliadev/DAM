import { ModalController } from '@ionic/angular';
import { Component, OnInit } from '@angular/core';
import { GestionPersonasService } from 'src/app/servicios/gestion-personas.service';

@Component({
  selector: 'app-insertar',
  templateUrl: './insertar.page.html',
  styleUrls: ['./insertar.page.scss'],
})
export class InsertarPage implements OnInit {
  id: string;
  nombre: string;
  apellido: string;

  constructor(private gestionPersonas: GestionPersonasService, public modal: ModalController) { }

  ngOnInit() {
  }

  onClick() {

    // Insertar
    this.gestionPersonas.InsertarPersonas(this.id, this.nombre, this.apellido);

    //dismiss
    this.modal.dismiss()
  }

}
