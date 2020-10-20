import { CursosService } from './cursos.service';
import { Component, OnInit } from '@angular/core';
import { InstituicoesService } from '../instituicoes/instituicoes.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.scss']
})
export class CursosComponent implements OnInit {

  cursos = [];
  curso: any;
  editando = false;
  detalhando = false;
  titulo = '';
  newId = 0;
  instituicoes = [];

  constructor(private cursosService: CursosService,
              private instituicoesService: InstituicoesService
              ) { }

  // tslint:disable-next-line: typedef
  ngOnInit() {
    this.buscarCursos();
  }

  buscarCursos() {
    this.cursosService.buscarCursos(this.curso).subscribe((resultado: any) => {
      this.cursos = resultado;
      this.cursos.sort((a, b) => (a.nome < b.nome) ? -1 : 1);
    });
    this.instituicoesService.buscarInstituicoes(null).subscribe((resultado: any) => {
      this.instituicoes = resultado;
    });
  }

  // tslint:disable-next-line: typedef
  excluir(curso) {
    /*
    this.confirmationService.confirm({
      message: 'Deseja realmente excluir o curso' + curso.nome,
      accept: () => {
      },
      reject: () => false
    });*/
    this.cursos = this.cursos.filter(item => item.id !== curso.id);
  }

  // tslint:disable-next-line: typedef
  editar(curso) {
    this.curso = JSON.parse(JSON.stringify(curso));
    this.editando = true;
    this.titulo = 'Editar Curso ' + curso.nome;
  }

  // tslint:disable-next-line: typedef
  detalhar(curso) {
    this.curso = JSON.parse(JSON.stringify(curso));
    this.detalhando = true;
    this.titulo = 'Detalhar Curso ' + curso.nome;
  }

  criar() {
    this.curso = {};
    this.editando = true;
    this.titulo = 'Criar Novo Curso';
  }

  finalizarAcao(event) {
    if (event.editar) {
      this.salvar(event.curso);
    } else {
      this.fecharModais();
    }
  }

  salvar(curso) {
    if (!this.validarDados(curso)){
      return false;
    }
    if (curso.codigo) {
      this.cursosService.editar(curso).subscribe(() => {
        this.buscarCursos();
      });
    } else {
      this.cursosService.criar(curso).subscribe((resultado: any) => {
        this.cursos.push(resultado);
        this.cursos.sort((a, b) => (a.nome < b.nome) ? -1 : 1);
      });
    }
    this.fecharModais();
  }

  validarDados(curso) {
    let valido = true;
    this.cursos.forEach(item => {
      if (item.nome === curso.nome && curso.id !== item.id) {
        valido = false;
      }
    });
    return valido;
  }

  fecharModais() {
    this.editando = false;
    this.detalhando = false;
    this.titulo = '';
    this.cursos.sort((a, b) => (a.nome < b.nome) ? -1 : 1);
  }
}
