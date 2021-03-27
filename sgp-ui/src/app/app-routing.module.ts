import { LoginComponent } from './seguranca/login/login.component';
import { ConfiguracaoComponent } from './configuracao/configuracao.component';
import { FinancasComponent } from './financas/financas.component';
import { CursosComponent } from './cursos/cursos.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InstituicoesComponent } from './instituicoes/instituicoes.component';
import { AuthGuard } from './seguranca/auth.guard';

const routes: Routes = [
    {path: '', redirectTo: 'cursos', pathMatch: 'full'},
    {path: 'cursos', component: CursosComponent, canActivate: [AuthGuard]},
    {path: 'instituicoes', component: InstituicoesComponent, canActivate: [AuthGuard]},
    {path: 'financas', component: FinancasComponent, canActivate: [AuthGuard]},
    {path: 'configuracoes', component: ConfiguracaoComponent, canActivate: [AuthGuard]},
    //{path: 'pagina-nao-encontrada', component: PaginaNaoEncontradaComponent},
    {path: 'login', component: LoginComponent},
    {path: '**', redirectTo: 'cursos'},
];

@NgModule({
    imports: [
      RouterModule.forRoot(routes)
    ],
    exports: [RouterModule]
})
  export class AppRoutingModule { }
