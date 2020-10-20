import { ConfiguracaoComponent } from './configuracao/configuracao.component';
import { FinancasComponent } from './financas/financas.component';
import { CursosComponent } from './cursos/cursos.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InstituicoesComponent } from './instituicoes/instituicoes.component';

const routes: Routes = [
    {path: '', redirectTo: 'cursos', pathMatch: 'full'},
    {path: 'cursos', component: CursosComponent},
    {path: 'instituicoes', component: InstituicoesComponent},
    {path: 'financas', component: FinancasComponent},
    {path: 'configuracao', component: ConfiguracaoComponent},
    //{path: 'pagina-nao-encontrada', component: PaginaNaoEncontradaComponent},
    {path: '**', redirectTo: 'cursos'},
];

@NgModule({
    imports: [
      RouterModule.forRoot(routes)
    ],
    exports: [RouterModule]
})
  export class AppRoutingModule { }
