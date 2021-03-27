import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { SegurancaService } from '../seguranca.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  usuario: any = {};

  constructor(private segurancaService: SegurancaService,
              private router: Router,
              private messageService: MessageService) { }

  ngOnInit() {
  }

  login() {
    this.segurancaService.logar(this.usuario).subscribe((res:any) => {
      if (res && res.status && this.segurancaService.descriptografar(res.senha) === this.usuario.senha) {
        localStorage.setItem('usuarioLogado', JSON.stringify(res));
        this.router.navigateByUrl('/cursos');
      } else {
        this.messageService.add({ severity: 'erro', summary: 'Erro ao logar!', detail: 'Usuáro ou senha incorreto' });
      }
    });
  }

}
