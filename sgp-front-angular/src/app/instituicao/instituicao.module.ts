import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { PipesModule } from '../pipes/pipes.module';
import { InstituicaoComponent } from './instituicao.component';

import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { TooltipModule } from 'primeng/tooltip';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';
import { DialogModule } from 'primeng/dialog';
import { InputNumberModule } from 'primeng/inputnumber';
import { FileUploadModule } from 'primeng/fileupload';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    BrowserModule,
    HttpClientModule,
    PipesModule,
    TableModule,
    ButtonModule,
    InputTextModule,
    TooltipModule,
    ConfirmDialogModule,
    BrowserAnimationsModule,
    DialogModule,
    InputNumberModule,
    FileUploadModule,
  ],
  declarations: [InstituicaoComponent],
  providers: [ConfirmationService],
  exports: [InstituicaoComponent]
})
export class InstituicaoModule { }
