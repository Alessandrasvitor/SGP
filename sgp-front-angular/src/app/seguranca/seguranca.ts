import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router } from "@angular/router";

@Injectable({
  providedIn: 'root'
}) 
export class Seguranca implements CanActivate {

  constructor(
    private router: Router
  ) { }

  canActivate(next: ActivatedRouteSnapshot) {

    /*
    if (this.auth.isLoggedIn !== true) {
      console.log('Navegação com access token inválido.');
      this.router.navigate(['/login']);
      return false;
    }
    let route = next.routeConfig.path;
    if (route.indexOf('/') >= 0) {
      route = JSON.parse(JSON.stringify(route.slice(0, route.indexOf('/')) + 's'));
    }
    if (!this.configService.validarAcessoTela(route.toUpperCase())) {
      this.router.navigate(['/pagina-nao-encontrada']);
    }*/
    return true;
  }


}
