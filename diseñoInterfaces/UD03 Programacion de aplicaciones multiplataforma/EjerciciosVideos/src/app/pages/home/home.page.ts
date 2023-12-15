import { AlertController, ModalController } from '@ionic/angular';
import { Component } from '@angular/core';
import { GestionPersonasService, IPersona } from 'src/app/servicios/gestion-personas.service';
import { InsertarPage } from '../insertar/insertar.page';




@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

// los contructrores tienen que usar ese servicio
  constructor( public gestionPersonas: GestionPersonasService, private alerta: AlertController, private modal: ModalController) {}

  borrar(id: string){
    this.gestionPersonas.borrarPersona(id);
  }

  modificar(persona: IPersona){
    this.presentarAlerta(persona);
  }

  async presentarAlerta(persona: IPersona) {
    const alert = await this.alerta.create({
      header: 'Modificar??',
      message: 'Actualizar los valores',
      inputs: [
        {
          name: 'ID',
          type: 'text',
          placeholder: 'Introduce el id', value: persona.id
        },
        {
          name: 'Nombre',
          type: 'text',
          placeholder: 'Introduce el nombre', value: persona.nombre
        },
        {
          name: 'Apellido',
          type: 'text',
          placeholder: 'Introduce el apellido', value: persona.apellido
        },
      ],
      buttons: [
        {
          text: 'Cancelar',
          role: 'cancel',
          cssClass: 'secondary',
          handler: () => {
            console.log('Confirm Cancel: blah');
          }
        }, {
          text: 'Okay',
          handler: (data) => {
            console.log(data);
            this.gestionPersonas.modificarPersona(data.ID, data.Nombre, data.Apellido);
          }
        }
      ]
    });

    await alert.present();
  }

  async presentarModal() {
    const modal = await this.modal.create({
      backdropDismiss: false,
      component: InsertarPage,
      cssClass: 'my-custom-class'
    });
    return await modal.present();
  }



}
