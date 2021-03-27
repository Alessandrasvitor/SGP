
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Seguranca } from './seguranca/seguranca';
import { CursoComponent } from './curso/curso.component';
import { InstituicaoComponent } from './instituicao/instituicao.component';

const routes: Routes = [
  { path: '', component: CursoComponent },
  { path: 'cursos', component: CursoComponent, canActivate: [Seguranca] },
  { path: 'instituicoes', component: InstituicaoComponent, canActivate: [Seguranca] },
  { path: '**', component: CursoComponent, canActivate: [Seguranca] },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
