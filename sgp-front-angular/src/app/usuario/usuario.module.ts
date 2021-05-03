import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsuarioComponent } from './usuario.component';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { ButtonModule } from 'primeng/button';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    BrowserModule,
    ButtonModule,

    InputTextModule
  ],
  declarations: [UsuarioComponent]
})
export class UsuarioModule { }
