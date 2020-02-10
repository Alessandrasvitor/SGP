import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { PanelModule } from 'primeng/panel';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';

import { AppComponent } from './app.component';

import { CursoComponent } from './curso/curso.component';
import { MenuComponent } from './menu/menu.component';
import { BotoesComponent } from './botoes/botoes.component';
import { CursoPesquisaComponent } from './curso-pesquisa/curso-pesquisa.component';


@NgModule({
  declarations: [
    AppComponent,
    CursoComponent,
    MenuComponent,
    BotoesComponent,
    CursoPesquisaComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,

    PanelModule,
    InputTextModule,
    ButtonModule,
    ToastModule,
  ],
  providers: [MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
