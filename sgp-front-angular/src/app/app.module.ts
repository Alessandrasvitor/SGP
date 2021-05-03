import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { CursoModule } from './curso/curso.module';
import { InstituicaoModule } from './instituicao/instituicao.module';
import { UsuarioModule } from './usuario/usuario.module';

import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import { MenuComponent } from './menu/menu.component';
import { MenubarModule } from 'primeng/menubar';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    MenubarModule,
    CursoModule,
    ToastModule,
    InstituicaoModule,
    UsuarioModule,
  ],
  providers: [MessageService],
  bootstrap: [AppComponent],
  exports: []
})
export class AppModule { }
