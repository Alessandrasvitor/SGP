import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { ConfigService } from '../config.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent implements OnInit {
  @Input() usuarios = [];
  perfis = [];
  usuario: any;
  editando = false;
  detalhando = false;
  modalEdicao = false;
  titulo = '';

  @Output() atualizarUsuario = new EventEmitter();

  constructor(private configService: ConfigService,
              private messageService: MessageService,
              private confirmationService: ConfirmationService) { }

  // tslint:disable-next-line: typedef
  ngOnInit() {
    this.perfis = [
      {label: 'Administrador', value: 'ADMINISTRADOR'},
      {label: 'Gestor', value: 'GESTOR'},
      {label: 'Usuário', value: 'USUARIO'}
    ];
  }

  // tslint:disable-next-line: typedef
  excluir(usuario) {
    this.confirmationService.confirm({
      message: 'Deseja excluir ' + usuario.nome + '? (Essa operação não poderá ser desfeita)',
      accept: () => {
         this.configService.deletarUsuario(usuario.codigo).subscribe(() => {
          this.messageService.add({ severity: 'success', summary: 'Usuário excluido com sucesso!', detail: '' });
          this.usuarios = this.usuarios.filter(item => item.codigo !== usuario.codigo);
        });
      }
    });
  }

  // tslint:disable-next-line: typedef
  editar(entidade) {
    this.usuario = JSON.parse(JSON.stringify(entidade));
    if (this.usuario.status === 'ATIVO') {
      this.usuario.ativo = true;
    } else {
      this.usuario.ativo = false;
    }
    this.editando = true;
    this.modalEdicao = true;
    this.titulo = 'Editar Usuário ' + entidade.nome;
  }

  // tslint:disable-next-line: typedef
  detalhar(entidade) {
    this.usuario = JSON.parse(JSON.stringify(entidade));
    if (this.usuario.status === 'ATIVO') {
      this.usuario.ativo = true;
    } else {
      this.usuario.ativo = false;
    }
    this.detalhando = true;
    this.modalEdicao = true;
    this.titulo = 'Detalhar Usuário ' + entidade.nome;
  }

  // tslint:disable-next-line: typedef
  ligar() {
    
  }

  criar() {
    this.usuario = {ativo: true};
    this.editando = true;
    this.modalEdicao = true;
    this.titulo = 'Criar Novo Usuário';
  }

  finalizarAcao(event) {
    if (event.editar) {
      this.salvar(event.entidade);
    } else {
      this.fecharModais();
    }
  }

  salvar(usuario) {
    if (!this.validarDados(usuario)){
      return false;
    }
    if (usuario.ativo) {
      usuario.status = 'ATIVO';
    } else {
      usuario.status = 'INATIVO';
    }
    if (usuario.codigo) {
      this.configService.salvarUsuario(usuario).subscribe(() => {
        this.atualizar();
      });
    }
    this.fecharModais();
  }

  validarDados(entidade) {
    const valido = true;
    if (entidade.senha !== entidade.contraSenha) {
      this.messageService.add({ severity: 'warn', summary: 'Contrasenha invalida!', detail: 'A contrasenha deve ser a mesma que a senha' });
      return false;
    }
    this.usuarios.forEach(item => {
      if (item.email === entidade.email && entidade.id !== item.id) {
        // tslint:disable-next-line: max-line-length
        this.messageService.add({ severity: 'warn', summary: 'Registro duplicado!', detail: 'Já existe um usuário com o email informado' });
        return false;
      }
    });
    return valido;
  }

  fecharModais() {
    this.editando = false;
    this.detalhando = false;
    this.modalEdicao = false;
    this.titulo = '';
    this.usuarios.sort((a, b) => (a.nome < b.nome) ? -1 : 1);
  }

  cancelar() {
    this.fecharModais();
  }

  atualizar() {
    this.atualizarUsuario.emit(true);
  }

}
