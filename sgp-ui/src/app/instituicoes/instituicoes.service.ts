import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InstituicoesService {

  url = `${environment.apiUrl}/instituicoes`;
  constructor(private http: HttpClient) { }

  buscarInstituicoes(instituicao: any) {
    return this.http.get(this.url);
  }

  criar(instituicao: any) {
    return this.http.post(this.url, instituicao);
  }

  editar(instituicao: any) {
    return this.http.put(this.url + '/' + instituicao.codigo, instituicao);
  }

  deletar(codigo) {
    return this.http.delete(this.url + '/' + codigo);
  }

}
