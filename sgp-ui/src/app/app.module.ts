import { EditarCursoComponent } from './cursos/editar-curso/editar-curso.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CursosComponent } from './cursos/cursos.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { AppRoutingModule } from './app-routing.module';
import { UsuariosComponent } from './configuracao/usuarios/usuarios.component';
import { FinancasComponent } from './financas/financas.component';
import { ConfiguracaoComponent } from './configuracao/configuracao.component';
import { CalendarioComponent } from './calendario/calendario.component';
import { LoginComponent } from './seguranca/login/login.component';

import { TabMenuModule } from 'primeng/tabmenu';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
import { PanelModule } from 'primeng/panel';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InputTextModule } from 'primeng/inputtext';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { InstituicoesComponent } from './instituicoes/instituicoes.component';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ToastModule } from 'primeng/toast';
import { ConfirmationService, MessageService } from 'primeng/api';
import { EditarInstituicaoComponent } from './instituicoes/editar-instituicao/editar-instituicao.component';
import { DropdownModule } from 'primeng/dropdown';
import { TabViewModule } from 'primeng/tabview';
import { DialogModule } from 'primeng/dialog';
import { InputSwitchModule } from 'primeng/inputswitch';
import { PasswordModule } from 'primeng/password';

@NgModule({
  declarations: [
    AppComponent,
    CursosComponent,
    NavBarComponent,
    FinancasComponent,
    UsuariosComponent,
    ConfiguracaoComponent,
    EditarCursoComponent,
    InstituicoesComponent,
    EditarInstituicaoComponent,
    CalendarioComponent,
    LoginComponent
   ],
  imports: [
    BrowserModule,
    TabMenuModule,
    AppRoutingModule,
    TableModule,
    ButtonModule,
    ToastModule,
    TooltipModule,
    FormsModule,
    DropdownModule,
    PanelModule,
    BrowserAnimationsModule,
    InputTextModule,
    TabViewModule,
    InputTextareaModule,
    HttpClientModule,
    ConfirmDialogModule,
    DialogModule,
    InputSwitchModule,
    PasswordModule
  ],
  providers: [
    ConfirmationService,
    MessageService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
