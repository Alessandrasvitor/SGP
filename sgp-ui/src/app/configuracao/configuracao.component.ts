import { Component, OnInit } from '@angular/core';
import { ConfirmationService } from 'primeng/api';
import { ConfigService } from './config.service';

@Component({
  selector: 'app-configuracao',
  templateUrl: './configuracao.component.html',
  styleUrls: ['./configuracao.component.scss']
})
export class ConfiguracaoComponent implements OnInit {

  usuarios = [];

  constructor(private configService: ConfigService,
              private confirmationService: ConfirmationService) { }

  ngOnInit() {
    this.buscarUsuarios();
  }

  buscarUsuarios() {
    this.configService.buscarUsuarios(this.usuarios).subscribe((resultado: any) => {
      this.usuarios = resultado;
      this.usuarios.sort((a, b) => (a.nome < b.nome) ? -1 : 1);
    });
  }

}
