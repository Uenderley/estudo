import { Component, OnInit } from '@angular/core';
import { FluxoService } from '../../services/fluxo.service';

import { Fluxo } from '../../models/fluxo';

@Component({
  selector: 'app-fluxo',
  templateUrl: './fluxo.component.html',
  styleUrls: ['./fluxo.component.css']
})
export class FluxoComponent implements OnInit {

  fluxos: Fluxo[];

  selTodosFluxos: boolean;

  constructor(private fluxoService: FluxoService) { }

  ngOnInit() {
    this.getFluxos();
  }

  getFluxos(): void {
    this.fluxoService.getFluxos()
        .subscribe(fluxos => this.fluxos = fluxos);
  }

  selecionarTodosFluxos(): void {
    if(this.selTodosFluxos){
      this.fluxos.forEach(function iterator(value){
        value.checked = true;
      });
    } else {
      this.fluxos.forEach(function iterator(value){
        value.checked = false;
      });
    }
  }
  

}
