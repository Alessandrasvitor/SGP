import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import * as cryptoJS from 'crypto-js';

@Injectable({
  providedIn: 'root'
})
export class SegurancaService {

  chave = 'EnterpriceAJ';

  url = environment.apiUrl;
  constructor(private http: HttpClient) { }


  logar(usuario) {
    return this.http.put(this.url + '/usuarios/email', usuario);
  }

  criptografar(senha) {
    if (senha) {
      return cryptoJS.AES.encrypt(senha.trim(), this.chave.trim()).toString();
    }
    return '';
  }

  descriptografar(senha) {
    if (senha) {
      return cryptoJS.AES.decrypt(senha.trim(), this.chave.trim()).toString(cryptoJS.enc.Utf8);
    }
    return '';
  }

  logado() {
    const logado = localStorage.getItem('usuarioLogado');
  }

  validarAcessoTela(tela) {
    const usuarioLogado = JSON.parse(localStorage.getItem('usuarioLogado'));
    return usuarioLogado.permissoes.indexOf(tela) >= 0;
  }

}
