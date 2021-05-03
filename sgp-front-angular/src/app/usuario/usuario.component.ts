import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  usuario: any;

  constructor() { }

  ngOnInit() {
    this.usuario = {};
  }

  salvar() {
    this.usuario = this.usuario;
  }

  cancelar() {
    this.usuario = {};
  }

}
