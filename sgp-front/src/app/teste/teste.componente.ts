import { Component } from '@angular/core';

@Component({
  selector: 'teste-componente',
  template: `
                <h2> {{ nome }} </h2>
              `
})
export class TesteComponent {
  nome = 'Teste de criação de componente';
}
