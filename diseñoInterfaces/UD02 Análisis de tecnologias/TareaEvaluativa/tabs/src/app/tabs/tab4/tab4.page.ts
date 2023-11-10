import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tab4',
  templateUrl: './tab4.page.html',
  styleUrls: ['./tab4.page.scss'],
})
export class Tab4Page implements OnInit {
  private numeroAdivinar!: number;
  public mensaje: string = '';
  public numeroIntroducido: number | null = null;

  ngOnInit() {
    this.numeroAdivinar = Math.floor(Math.random() * 101);
  }

  comprobarNumero() {
    if (this.numeroIntroducido !== null) {
      if (this.numeroIntroducido < 0 || this.numeroIntroducido > 100) {
        this.mensaje = 'Introduce un número entre 0 y 100';
      } else if (this.numeroIntroducido < this.numeroAdivinar) {
        this.mensaje = 'Introduce un número mayor';
      } else if (this.numeroIntroducido > this.numeroAdivinar) {
        this.mensaje = 'Introduce un número menor';
      } else {
        this.mensaje = '¡Has acertado!';
      }
    } else {
      this.mensaje = 'Por favor, introduce un número';
    }
  }
}
