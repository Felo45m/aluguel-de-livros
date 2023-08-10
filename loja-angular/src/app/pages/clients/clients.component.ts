import { Component, OnInit } from '@angular/core';
import { IClient } from 'src/app/interfaces/client';
import { AlertService } from 'src/app/services/alert.service';
import { ClientsService } from 'src/app/services/clients.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  constructor(private clientsService: ClientsService,  private alertService: AlertService) {}

  clients: IClient[] = [];

  ngOnInit(): void {
    this.listClients();
  }

  listClients() {
    this.clientsService.listClients().subscribe((clients: IClient[]) => {
      this.clients = clients;
    }, (error => {
      console.error(error);
    }))
  }

  delete(id?: number) {
    if (id) {
      this.clientsService.deleteClientById(id).subscribe(() => {
        this.alertService.alertSuccess('Cliente removido com sucesso!');
        this.listClients();
      }, (error) => {
        console.error(error);
      })
    }
      return;
  }
}
