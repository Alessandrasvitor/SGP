import { InstituicoesService } from './instituicoes.service';
import { Component, OnInit } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';

@Component({
  selector: 'app-instituicoes',
  templateUrl: './instituicoes.component.html',
  styleUrls: ['./instituicoes.component.scss']
})
export class InstituicoesComponent implements OnInit {

  instituicoes = [];
  instituicao: any;
  editando = false;
  detalhando = false;
  titulo = '';

  constructor(private instituicoesService: InstituicoesService,
              private messageService: MessageService,
              private confirmationService: ConfirmationService) { }

  // tslint:disable-next-line: typedef
  ngOnInit() {
    this.buscarEntidades();
  }

  buscarEntidades() {
    this.instituicoesService.buscarInstituicoes(this.instituicoes).subscribe((resultado: any) => {
      this.instituicoes = resultado;
      this.instituicoes.sort((a, b) => (a.nome < b.nome) ? -1 : 1);
    });
  }

  // tslint:disable-next-line: typedef
  excluir(instituicao) {
    this.confirmationService.confirm({
      message: 'Deseja excluir ' + instituicao.nome + '? (Essa operação não poderá ser desfeita)',
      accept: () => {
         this.instituicoesService.deletar(instituicao.codigo).subscribe(() => {
          this.messageService.add({ severity: 'success', summary: 'Instituição excluida com sucesso!', detail: '' });
          this.instituicoes = this.instituicoes.filter(item => item.codigo !== instituicao.codigo);
        });
      }
    });
  }

  // tslint:disable-next-line: typedef
  editar(entidade) {
    this.instituicao = JSON.parse(JSON.stringify(entidade));
    this.editando = true;
    this.titulo = 'Editar Instituição ' + entidade.nome;
  }

  // tslint:disable-next-line: typedef
  detalhar(entidade) {
    this.instituicao = JSON.parse(JSON.stringify(entidade));
    this.detalhando = true;
    this.titulo = 'Detalhar instituição ' + entidade.nome;
  }

  criar() {
    this.instituicao = {};
    this.editando = true;
    this.titulo = 'Criar Nova Instituição';
  }

  finalizarAcao(event) {
    if (event.editar) {
      this.salvar(event.entidade);
    } else {
      this.fecharModais();
    }
  }

  salvar(instituicao) {
    if (!this.validarDados(instituicao)){
      return false;
    }
    if (instituicao.codigo) {
      this.instituicoesService.editar(instituicao).subscribe(() => {
        this.buscarEntidades();
      });
    } else {
      this.instituicoesService.criar(instituicao).subscribe((resultado: any) => {
        this.instituicoes.push(resultado);
        this.instituicoes.sort((a, b) => (a.nome < b.nome) ? -1 : 1);
      });
    }
    this.fecharModais();
  }

  validarDados(entidade) {
    let valido = true;
    this.instituicoes.forEach(item => {
      if (item.nome === entidade.nome && entidade.id !== item.id) {
        valido = false;
      }
    });
    return valido;
  }

  fecharModais() {
    this.editando = false;
    this.detalhando = false;
    this.titulo = '';
    this.instituicoes.sort((a, b) => (a.nome < b.nome) ? -1 : 1);
  }

}
