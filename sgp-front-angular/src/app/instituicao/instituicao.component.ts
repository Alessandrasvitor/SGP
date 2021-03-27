import { InstituicaoService } from './instituicao.service';
import { Component, OnInit } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { UtilService } from '../util.service';

@Component({
  selector: 'app-instituicao',
  templateUrl: './instituicao.component.html',
  styleUrls: ['./instituicao.component.css']
})
export class InstituicaoComponent implements OnInit {

  instituicao: any;
  instituicoes: any;
  instituicoesAux: any;
  editando = false;
  addNota = false;
  
  uploadedFiles: any[] = [];

  constructor(private instituicaoService: InstituicaoService,
    private messageService: MessageService,
    private utilService: UtilService,
    private confirmationService: ConfirmationService) { }

  ngOnInit(): void {
    this.atualizar();
  }

  atualizar() {
    this.instituicaoService.listarTodos().subscribe(rest => {
      this.instituicoes = rest;
      this.limparCampos();
    });
  }

  criarNovo() {
    this.editando = true;
    this.validaListaLimpa();
    this.instituicoesAux = JSON.stringify(this.instituicoes);
    this.instituicao = {nome: '', avaliacao: 0.0, editando: true, endereco: ''};
    this.instituicoes.unshift(this.instituicao);
  }

  editar(instituicaoEdit) {
    this.editando = true;
    this.instituicoesAux = JSON.stringify(this.instituicoes);
    this.instituicao = instituicaoEdit;
    this.instituicao.editando = true;
  }

  salvar(instituicaoEdit) {

    if(!this.utilService.validaDuplicado(this.instituicoes, instituicaoEdit)) {
      this.messageService.add({severity: 'warn', summary: 'Campo duplicado', detail: 'A instituição informada já existe salva no sistema'});
      return;
    }
    if(instituicaoEdit.id) {
      this.instituicaoService.editar(instituicaoEdit).subscribe(() => {this.atualizar();});
    } else {
      this.instituicaoService.salvar(instituicaoEdit).subscribe(() => {this.atualizar();});
    }
  }

  deletar(instituicao) {
    this.confirmationService.confirm({
      message: 'Deseja realmente excluir o curso '+ instituicao.nome +'?',
      accept: () => {
        this.instituicaoService.deletar(instituicao.id).subscribe(() => {
          this.atualizar();
        });
      }
    });
  }

  validaListaLimpa() {
    if(!this.instituicoes) {
      this.instituicoes = [];
    }
  }

  cancelar() {
    this.instituicoes = JSON.parse(this.instituicoesAux);
    this.limparCampos();
  }

  limparCampos() {
    this.editando = false;
    this.addNota = false;
    this.instituicoesAux = null;
    this.instituicao = null;
  }

}
