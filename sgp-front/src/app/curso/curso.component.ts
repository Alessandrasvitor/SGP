import { Component, OnInit } from '@angular/core';
import { CursoService } from '../curso.service';

import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrls: ['./curso.component.css']
})
export class CursoComponent{
  cursos = [];
  curso = {};
  titulo = 'Cursos';


  constructor(
    private cursoService: CursoService,
    private messageService: MessageService
  ) { }

  ngOnInit() {
    this.consultar();
  }

  consultar() {
    this.cursoService.listar()
      .subscribe(resposta => this.cursos = <any>resposta)
  }

  adicionar() {
    this.cursoService.adicionar(this.curso)
      .subscribe(() => {
        this.curso = {};
        this.consultar();
      });
  }

  /**
   *
  adicionar() {
    this.oportunidadeService.adicionar(this.oportunidade)
      .subscribe(() => {
        this.oportunidade = {};
        this.consultar();

        this.messageService.add({
          severity: 'success',
          summary: 'Oportunidade adicionada com sucesso'
        });
      },
      resposta => {
        let msg = 'Erro inesperado. Tente novamente.';

        if (resposta.error.message) {
          msg = resposta.error.message;
        }

        this.messageService.add({
          severity: 'error',
          summary: msg
        });
      });
  }
  */


}
