import { AlertController } from '@ionic/angular';
import { Component } from '@angular/core';
import { GestionPersonasService, IPersona } from 'src/app/servicios/gestion-personas.service';




@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

// los contructrores tienen que usar ese servicio
  constructor( public gestionPersonas: GestionPersonasService, private alerta: AlertController) {}

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
          name: 'nombre',
          type: 'text',
          placeholder: 'Introduce el nombre', value: persona.nombre
        },
        {
          name: 'apellido',
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
          handler: () => {
            console.log('Confirm Okay');
          }
        }
      ]
    });

    await alert.present();
  }


}
