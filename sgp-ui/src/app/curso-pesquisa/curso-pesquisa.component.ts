import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-curso-pesquisa',
  templateUrl: './curso-pesquisa.component.html',
  styleUrls: ['./curso-pesquisa.component.css']
})
export class CursoPesquisaComponent implements OnInit {

  cursos = {};

  constructor() { }

  ngOnInit(): void {
  }

}
