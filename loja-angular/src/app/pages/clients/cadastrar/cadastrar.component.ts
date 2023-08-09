import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { IClient } from 'src/app/interfaces/client';
import { AlertService } from 'src/app/services/alert.service';
import { ClientsService } from 'src/app/services/clients.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarEditarComponent implements OnInit {

  constructor(
    private alertService: AlertService,
    private clientsService: ClientsService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  clientId = 0;

  clientForm = new FormGroup({
    name: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    phone: new FormControl('', Validators.required)
  })

  ngOnInit(): void {
    this.clientId = Number(this.route.snapshot.paramMap.get('id'));
    if (this.clientId !== 0) {
      this.clientsService.getClientById(this.clientId).subscribe((client: IClient) => {
        this.clientForm.setValue({
          name: client.name,
          email: client.email,
          phone: client.phone
        });
      }, (error) => {
        console.error(error);
      })
    }
  }

  creatForm(client?: IClient) {
    return new FormGroup({
      nome: new FormControl(client?.name ? client?.name : '', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      phone: new FormControl('', Validators.required)
    });
  }

  register() {
    const client: IClient = this.clientForm.value as IClient;
    if (this.clientId) {
      client._id = this.clientId;
      this.clientsService.updateClient(client).subscribe(() => {
        this.alertService.alertSuccess('Editado com sucesso!');
        this.router.navigateByUrl('/clientes');
      })
      return;
    }

    this.clientsService.saveClient(client).subscribe(() => {
      this.alertService.alertSuccess('Editado com sucesso!');
      this.router.navigateByUrl('/clientes');
    }, (error) => {
      console.error(error);
    });
  }
}
