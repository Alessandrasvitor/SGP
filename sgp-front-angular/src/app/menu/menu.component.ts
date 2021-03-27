import { Component, OnInit } from '@angular/core';

import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  items: MenuItem[];

  constructor() { }

  ngOnInit() {
    this.items = [{ label: 'Curso', icon: 'pi pi-book', routerLink: '/cursos' }, 
                  { label: 'Instituição Acadêmica', icon: 'pi pi-home', routerLink: '/instituicoes' }]
  }

}
