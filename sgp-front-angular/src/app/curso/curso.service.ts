import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  private url = `${environment.apiUrl}/curso`;
  
  constructor(private http: HttpClient) { }

  listarTodos() {
    return this.http.get(this.url,{});
  }

  salvar(curso) {
    return this.http.post(this.url, curso, {});
  }

  editar(curso) {
    return this.http.put(this.url + '/' + curso.id, curso, {});
  }

  deletar(id) {
    return this.http.delete(this.url + '/' + id, {});
  }

  iniciar(id) {
    return this.http.put(this.url + '/avancar/' + id, {});
  }

  concluir(id, nota) {
    return this.http.put(this.url + '/concluir/' + id, nota, {});
  }

  reiniciar(id) {
    return this.http.put(this.url + '/reiniciar/' + id, {});
  }

  upload(file) {
    const formData: FormData = new FormData();
    formData.append('fileKey', file, file.name);
    return this.http
      .post('http://localhost:8083/arquivo/upload', formData, {  })
  }

}
