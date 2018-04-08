import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AmbienteComponent } from './components/ambiente/ambiente.component';
import { FluxoComponent } from './components/fluxo/fluxo.component';
import { GitComponent } from './components/git/git.component';
import { HeaderComponent } from './components/header/header.component';

const routes: Routes = [
  { path: 'ambiente', component: AmbienteComponent },
  { path: 'fluxo', component: FluxoComponent},
  { path: 'git', component: GitComponent},
  { path: 'header', component: HeaderComponent}
];


@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
