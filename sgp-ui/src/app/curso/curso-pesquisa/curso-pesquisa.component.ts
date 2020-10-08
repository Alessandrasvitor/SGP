import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-curso-pesquisa',
  templateUrl: './curso-pesquisa.component.html',
  styleUrls: ['./curso-pesquisa.component.css']
})
export class CursoPesquisaComponent {

  curso = {};
  cursos = [{nome: 'JAVA', descricao: 'Java para iniciantes', plataforma: 'Prime Cursos', nota: 10.0},
            {nome: 'C#', descricao: 'C# para iniciantes', plataforma: 'Prime Cursos', nota: null},
            {nome: 'PHP', descricao: 'PHP para iniciantes', plataforma: 'Prime Cursos', nota: 6.5}];



}
