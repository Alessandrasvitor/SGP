import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StatusPipe } from './status.pipe';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [StatusPipe],
  exports: [
    StatusPipe
  ]
})
export class PipesModule { }
