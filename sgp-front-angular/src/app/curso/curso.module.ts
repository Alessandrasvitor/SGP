import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { CursoComponent } from './curso.component';
import { PipesModule } from '../pipes/pipes.module';

import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { TooltipModule } from 'primeng/tooltip';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';
import { DialogModule } from 'primeng/dialog';
import { InputNumberModule } from 'primeng/inputnumber';
import { FileUploadModule } from 'primeng/fileupload';
import { DropdownModule } from 'primeng/dropdown';

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
    DropdownModule,
  ],
  declarations: [CursoComponent],
  providers: [ConfirmationService],
  exports: [CursoComponent]
})
export class CursoModule { }
