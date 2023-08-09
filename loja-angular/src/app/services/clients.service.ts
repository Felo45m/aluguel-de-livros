import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IClient } from '../interfaces/client';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  private readonly API = 'api/clients'

  constructor(private http: HttpClient) { }

  listClients() {
    return this.http.get<IClient[]>(this.API);
  }

  saveClient( client: IClient) : Observable<IClient> {
    return this.http.post<IClient>(`${this.API}`, client)
  }

  updateClient( client: IClient) : Observable<any> {
    return this.http.put<IClient>(`${this.API}/${client._id}`, client)
  }

  getClients() : Observable<IClient[]> {
    return this.http.get<IClient[]>(this.API);
  }

  getClientById(_id: number) : Observable<IClient> {
    return this.http.get<any>(`${this.API}/${_id}`);
  }

  deleteClientById(client : IClient) : Observable<any> {
    return this.http.delete<any>(`${this.API}/${client._id}`)
  }
}
