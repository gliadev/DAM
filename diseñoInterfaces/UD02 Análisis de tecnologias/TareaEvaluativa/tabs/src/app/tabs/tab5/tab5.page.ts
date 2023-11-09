import { Component, OnInit } from '@angular/core';
import { IValor } from '../../Interfaces/valor.model';

@Component({
  selector: 'app-tab5',
  templateUrl: './tab5.page.html',
  styleUrls: ['./tab5.page.scss'],
})
export class Tab5Page implements OnInit {
  valoresLista: IValor[] = [
    {
      imagen: 'BIRT_LOGO.png',
      url: 'https://birt.eus',
    },
    {
      imagen: 'easo_logo.png',
      url: 'https://easo.hezkuntza.net',
    },
    {
      imagen: 'nicolas_larburu_logo.jpg',
      url: 'https://nlarburu.hezkuntza.net',
    },
    {
      imagen: 'ciudad_jardin_logo.png',
      url: 'https://ciudadjardin.hezkuntza.net',
    },
  ];

  constructor() {}

  ngOnInit() {}
}
