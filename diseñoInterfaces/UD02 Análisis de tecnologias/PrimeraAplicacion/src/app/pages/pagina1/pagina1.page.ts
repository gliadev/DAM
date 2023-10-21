import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina1',
  templateUrl: './pagina1.page.html',
  styleUrls: ['./pagina1.page.scss'],
})
export class Pagina1Page implements OnInit {

  pesoT: number;
  altura: number;
  imc: number;
  email:string;

  constructor() { }

  onClick() {
    console.log("Botón pulsado");
    this.imc = this.pesoT / Math.pow(this.altura, 2);
    this.imc = Math.round(this.imc * 100) / 100;
    console.log(this.imc);
  }

  ngOnInit() {
  }

}
