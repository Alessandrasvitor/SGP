import { CursoService } from './curso.service';
import { Component, OnInit } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { InstituicaoService } from '../instituicao/instituicao.service';
import { UtilService } from '../util.service';

@Component({
  templateUrl: './curso.component.html',
  styleUrls: ['./curso.component.css']
})
export class CursoComponent implements OnInit {

  curso: any;
  cursos: any;
  cursosAux: any;
  instituicoes: any;
  editando = false;
  addNota = false;
  
  uploadedFiles: any[] = [];

  constructor(private cursoService: CursoService,
    private messageService: MessageService,
    private utilService: UtilService,
    private instituicaoService: InstituicaoService,
    private confirmationService: ConfirmationService) { }

  ngOnInit(): void {
    this.atualizar();
    this.instituicaoService.listarTodos().subscribe(rest => {this.instituicoes = rest});
  }

  atualizar() {
    this.cursoService.listarTodos().subscribe(rest => {
      this.cursos = rest;
      this.limparCampos();
    });
  }

  criarCurso() {
    this.editando = true;
    this.validaListaLimpa();
    this.cursosAux = JSON.stringify(this.cursos);
    let instituicao = {nome: ''};
    this.curso = {status: 'PENDENTE', nota: 0.0, editando: true, instituicaoEnsino: instituicao};
    this.cursos.unshift(this.curso);
  }

  editar(cursoEdit) {
    this.editando = true;
    this.cursosAux = JSON.stringify(this.cursos);
    this.curso = cursoEdit;
    this.curso.editando = true;
  }

  salvar(cursoEdit) {

    if(!this.utilService.validaDuplicado(this.cursos, cursoEdit)) {
      this.messageService.add({severity: 'warn', summary: 'Campo duplicado', detail: 'O curso informado já existe salvo no sistema'});
      return;
    }
    if(cursoEdit.id) {
      this.cursoService.editar(cursoEdit).subscribe(() => {this.atualizar();});
    } else {
      this.cursoService.salvar(cursoEdit).subscribe(() => {this.atualizar();});
    }
  }

  deletar(curso) {
    this.confirmationService.confirm({
      message: 'Deseja realmente excluir o curso '+ curso.nome +'?',
      accept: () => {
        this.cursoService.deletar(curso.id).subscribe(() => {
          this.atualizar();
        });
      }
    });
  }

  validaListaLimpa() {
    if(!this.cursos) {
      this.cursos = [];
    }
  }

  reiniciar(curso) {
    this.confirmationService.confirm({
      message: 'Deseja realmente reiniciar o curso '+ curso.nome +'?',
      accept: () => {
        this.cursoService.reiniciar(curso.id).subscribe(() => {
          this.atualizar();
        });
      }
    });
  }

  cancelar() {
    this.cursos = JSON.parse(this.cursosAux);
    this.limparCampos();
  }

  iniciarCurso(id) {
    this.cursoService.iniciar(id).subscribe(() => {
      this.atualizar();
    });
  }

  limparCampos() {
    this.editando = false;
    this.addNota = false;
    this.cursosAux = null;
    this.curso = null;
  }

  adicionarNota(idCurso) {
    this.cursosAux = JSON.stringify(this.cursos);
    this.addNota = true;
    this.curso = {id: idCurso, nota: 0.0};

  }

  concluirCurso() {
    this.cursoService.concluir(this.curso.id, this.curso.nota).subscribe(() => {
      this.atualizar();
    });
  }

  onUpload(event) {
    if (event.target.files) {
      for (const file of event.target.files) {
        this.cursoService.upload(file).subscribe();
      }
    }
    
    this.messageService.add({severity: 'info', summary: 'Success', detail: 'File Uploaded'});
  }

}
