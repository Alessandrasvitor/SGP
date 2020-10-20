import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-editar-instituicao',
  templateUrl: './editar-instituicao.component.html',
  styleUrls: ['./editar-instituicao.component.scss']
})
export class EditarInstituicaoComponent implements OnInit {

  @Input() entidade: any;
  @Input() detalhando = false;
  @Input() editando = false;
  @Input() titulo = '';
  @Output() acaoEmiter = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  Cancelar() {
    this.acaoEmiter.emit({editar: false, entidade: null});
  }

  salvar() {
    this.acaoEmiter.emit({editar: true, entidade: this.entidade});
  }

}
