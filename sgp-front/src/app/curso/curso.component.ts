import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrls: ['./curso.component.css']
})
export class CursoComponent{
  curso;
  teste;

  adicionar(teste: any) {
    this.curso = teste;
  }

}
