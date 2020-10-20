import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { CursosComponent } from './cursos/cursos.component';

const routes: Routes = [
  {path: '', redirectTo: 'cursos', pathMatch: 'full'},
  {path: 'cursos', component: CursosComponent},
  {path: '**', redirectTo: 'cursos'},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
