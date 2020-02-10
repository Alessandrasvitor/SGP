import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  apiUrl = 'http://localhost:8088/cursos';

  constructor(private httpClient: HttpClient) { }

  listar() {
    return this.httpClient.get(this.apiUrl);
  }

  adicionar(curso: any) {
    return this.httpClient.post(curso, this.apiUrl);
  }

}
