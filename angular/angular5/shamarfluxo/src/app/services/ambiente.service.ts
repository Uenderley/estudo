import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { AMBIENTES } from '../mock-ambientes';

import { Ambiente } from '../models/ambiente';

@Injectable()
export class AmbienteService {

  constructor(private http: HttpClient) { }

  getAmbientes(): Observable<Ambiente[]> {
    return of(AMBIENTES);
  }
}
