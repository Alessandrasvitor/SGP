import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CursosService {
  url = `${environment.apiUrl}/cursos`;
  constructor(private http: HttpClient) { }

  buscarCursos(curso: any) {
    return this.http.get(this.url);
  }

  criar(curso: any) {
    return this.http.post(this.url, curso);
  }

  editar(curso: any) {
    return this.http.put(this.url + '/' + curso.codigo, curso);
  }

  deletar(codigo) {
    return this.http.delete(this.url + '/' + codigo);
  }

}
