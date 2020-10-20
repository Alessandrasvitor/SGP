import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-editar-curso',
  templateUrl: './editar-curso.component.html',
  styleUrls: ['./editar-curso.component.scss']
})
export class EditarCursoComponent implements OnInit {

  @Input() entidade: any;
  @Input() detalhando = false;
  @Input() editando = false;
  @Input() titulo = '';
  @Input() instituicoes = [];
  @Output() acaoEmiter = new EventEmitter();

  constructor() { }

  ngOnInit() {
    if (this.instituicoes && this.entidade && !this.entidade.instituicao && !this.detalhando) {
      this.entidade.instituicao = this.instituicoes[0];
    }
  }

  Cancelar() {
    this.acaoEmiter.emit({editar: false, curso: null});
  }

  salvar() {
    this.acaoEmiter.emit({editar: true, curso: this.entidade});
  }


}
