import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class AlertService {

  constructor() { }

  alertSuccess(mensagem: string) {
    Swal.fire({
      title: 'Sucesso!',
      text: mensagem,
      icon: 'success'
    })
  }

  alertError(mensagem: string) {
    Swal.fire({
      title: 'Erro!',
      text: mensagem,
      icon: 'error'
    })
  }
}
