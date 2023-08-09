import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BooksComponent } from './pages/books/books.component';
import { HomeComponent } from './pages/home/home.component';
import { ClientsComponent } from './pages/clients/clients.component';
import { CadastrarEditarComponent } from './pages/clients/cadastrar/cadastrar.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'books', component: BooksComponent
  },
  {
    path: 'clients', component: ClientsComponent
  },
  {
    path: 'clients/cadastrar', component: CadastrarEditarComponent
  },
  {
    path: 'books/cadastrar', component: CadastrarEditarComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
