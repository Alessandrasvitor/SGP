import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { TesteComponent } from './teste/teste.componente';
import { CursoComponent } from './curso/curso.component';
import { MenuComponent } from './menu/menu.component';
import { BotoesComponent } from './botoes/botoes.component';

@NgModule({
  declarations: [
    AppComponent,
    TesteComponent,
    CursoComponent,
    MenuComponent,
    BotoesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
