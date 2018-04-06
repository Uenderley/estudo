import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { FLUXOS } from '../mock-fluxos';

import { Fluxo } from '../models/fluxo';

@Injectable()
export class FluxoService {

  private urlFluxos = 'api/fluxos';

  constructor(private http: HttpClient) { }

  getFluxos(): Observable<Fluxo[]> {
    return of(FLUXOS);
  }
}
