import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UtilService {

constructor() { }

  validaDuplicado(lista, item) {
    let valido = true;
    lista.forEach(element => {
      if(element.nome === item.nome && element.id !== item.id) {
        valido = false;
      }      
    });
    return valido;
  }

}
