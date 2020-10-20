import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  url = environment.apiUrl;
  constructor(private http: HttpClient) { }

  buscarUsuarios(obj: any) {
    return this.http.get(this.url + '/usuarios');
  }

  salvarUsuario(obj: any) {
    return this.http.post(this.url + '/usuarios', obj);
  }

  deletarUsuario(codigo) {
    return this.http.delete(this.url + '/usuarios/' + codigo);
  }

}
