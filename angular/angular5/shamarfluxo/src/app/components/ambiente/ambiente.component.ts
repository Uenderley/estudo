import { Component, OnInit } from '@angular/core';

import { AmbienteService } from '../../services/ambiente.service';

import { Ambiente } from '../../models/ambiente';

@Component({
  selector: 'app-ambiente',
  templateUrl: './ambiente.component.html',
  styleUrls: ['./ambiente.component.css']
})
export class AmbienteComponent implements OnInit {

  private ambientes: Ambiente[];

  constructor(private ambienteService: AmbienteService) { }

  ngOnInit() {
    this.getAmbientes();
  }

  getAmbientes(): void{
    this.ambienteService.getAmbientes()
    .subscribe(ambientes => this.ambientes = ambientes);
  }

}
