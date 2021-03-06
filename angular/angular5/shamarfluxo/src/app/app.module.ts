import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http';

import { AppComponent } from './app.component';
import { FluxoComponent } from './components/fluxo/fluxo.component';

import { GitService } from './services/git.service';
import { FluxoService } from './services/fluxo.service';
import { GitComponent } from './components/git/git.component';
import { AmbienteComponent } from './components/ambiente/ambiente.component';
import { AmbienteService } from './services/ambiente.service';
import { HeaderComponent } from './components/header/header.component';
import { AppRoutingModule } from './/app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    FluxoComponent,
    GitComponent,
    AmbienteComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [GitService, FluxoService, AmbienteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
