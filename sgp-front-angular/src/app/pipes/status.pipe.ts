import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'status'
})
export class StatusPipe implements PipeTransform {

  transform(value: any): any {
    if(!value) {
      return null;
    } else if (value === 'PENDENTE') {
      return 'Pendente';
    } else if (value === 'EM_ANDAMENTO') {
      return 'Em Andamento';
    } else if (value === 'CONCLUIDO') {
      return 'Concluído';
    } else {
      return null;
    }




    return null;
  }

}
