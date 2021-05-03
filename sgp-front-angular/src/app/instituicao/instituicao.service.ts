import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InstituicaoService {

  private url = `${environment.apiUrl}/instituicao`;

  constructor(private http: HttpClient) { }

  listarTodos() {
    return this.http.get(this.url,{});
  }

  salvar(instituicao) {
    return this.http.post(this.url, instituicao, {});
  }

  editar(instituicao) {
    return this.http.put(this.url + '/' + instituicao.id, instituicao, {});
  }

  deletar(id) {
    return this.http.delete(this.url + '/' + id, {});
  }

}
