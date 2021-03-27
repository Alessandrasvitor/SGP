import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, Router } from '@angular/router';
import { SegurancaService } from './seguranca.service';

@Injectable({
  providedIn: 'root'
})

export class AuthGuard implements CanActivate {

  constructor(
    private segurancaService: SegurancaService,
    private router: Router
  ) { }

  canActivate(next: ActivatedRouteSnapshot)  {

    if (!localStorage.getItem('usuarioLogado')) {
      console.log('Navegação com access inválido.');
      this.router.navigate(['/login']);
      return false;
    }

    let route = next.routeConfig.path;
    if (route.indexOf('/') >= 0) {
      route = JSON.parse(JSON.stringify(route.slice(0, route.indexOf('/'))));
    }
    if (!this.segurancaService.validarAcessoTela(route.toUpperCase())) {
      console.log('Navegação com access inválido.');
      this.router.navigate(['/login']);
      return false;
    }
    return true;
  }

}
