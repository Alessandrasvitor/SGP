import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {

  items: MenuItem[];
  activeItem: MenuItem;

  constructor() { }

  // tslint:disable-next-line: typedef
  ngOnInit() {
    this.items = [
      {label: 'Cursos', icon: 'pi pi-fw pi-pencil', routerLink: 'cursos', id: 'CURSO'},
      {label: 'Instituições', icon: 'pi pi-fw pi-home', routerLink: 'instituicoes', id: 'INSTITUICAO'},
      {label: 'Calendário', icon: 'pi pi-fw pi-calendar', routerLink: 'telateste', id: 'CALENDARIO'},
      {label: 'Finanças', icon: 'pi pi-fw pi-dollar', routerLink: 'financas', id: 'FINANCA'},
      {label: 'Documentação', icon: 'pi pi-fw pi-file', routerLink: 'cursos', id: 'PADRAO'},
      {label: 'Configurações', icon: 'pi pi-fw pi-cog', routerLink: 'configuracao', id: 'CONFIGURACAO'}
    ];
  }
}
