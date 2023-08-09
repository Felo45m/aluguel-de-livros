import { Component, OnInit } from '@angular/core';
import { IClient } from 'src/app/interfaces/client';
import { ClientsService } from 'src/app/services/clients.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  constructor(private clientsService: ClientsService) {}

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

}
