import { Component, OnInit } from '@angular/core';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-tab4',
  templateUrl: './tab4.page.html',
  styleUrls: ['./tab4.page.scss'],
})
export class Tab4Page implements OnInit {
  private numeroAdivinar!: number;
  public mensaje: string = '';
  public numeroIntroducido: number | null = null;
  public juegoTerminado: boolean = false;
  public intentos: number = 0;

  constructor(private alertController: AlertController) {}

  ngOnInit() {
    this.resetearJuego();
  }

  resetearJuego() {
    this.numeroAdivinar = Math.floor(Math.random() * 101);
    this.numeroIntroducido = null;
    this.juegoTerminado = false;
    this.mensaje = '';
    this.intentos = 0;
  }

  async comprobarNumero() {
    if (this.numeroIntroducido !== null) {
      this.intentos++;

      if (this.numeroIntroducido < 0 || this.numeroIntroducido > 100) {
        this.mensaje = 'Introduce un número entre 0 y 100';
      } else if (this.numeroIntroducido < this.numeroAdivinar) {
        this.mensaje = 'Introduce un número mayor';
      } else if (this.numeroIntroducido > this.numeroAdivinar) {
        this.mensaje = 'Introduce un número menor';
      } else {
        this.mensaje = `Numero de Intentos: ${this.intentos}`;
        this.mensaje = `¡Enhorabuena!! Has acertado el numero secreto`;
        this.juegoTerminado = true;
        this.preguntarVolverAJugar();
      }
    } else {
      this.mensaje = 'Por favor, introduce un número';
    }
  }

  async preguntarVolverAJugar() {
    const alert = await this.alertController.create({
      header: 'Nuevo juego',
      message: '¿Quieres volver a jugar?',
      buttons: [
        {
          text: 'Cancelar',
          role: 'cancel',
        },
        {
          text: 'OK',
          handler: () => {
            this.resetearJuego();
          },
        },
      ],
    });

    await alert.present();
  }
}
