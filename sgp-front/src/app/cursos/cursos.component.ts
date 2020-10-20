import { Component, OnInit } from '@angular/core';
import { Curso } from './curso';

@Component({
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.scss']
})
export class CursosComponent implements OnInit {

  cursos: Curso[];
  curso: Curso;

  constructor() { }

  ngOnInit() {

    this.cursos = [{codigo: 1, nome: 'JAVA', plataforma: 'Alura', duracao: '80h', nota: 7},
                  {codigo: 2, nome: 'C#', plataforma: 'Alura', duracao: '60h', nota: 6}];
  }

}
