import { Component, OnInit } from '@angular/core';
import { Ficha } from 'app/models/ficha.model';
import { GeneradorFichaService } from 'app/services/generador-ficha.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-ficha',
  templateUrl: './ficha.component.html',
  styleUrls: ['./ficha.component.css']
})
export class FichaComponent implements OnInit {

  ficha: Ficha;
  aux_fecha: Date;

  constructor(private generadorFichaService: GeneradorFichaService, private datePipe: DatePipe) {
    this.ficha = new Ficha();
    this.aux_fecha = new Date();
  }

  ngOnInit(): void {
  }

  generarFicha() {
    this.generadorFichaService.postFicha(this.ficha);
  }
}
