import { NgModule } from '@angular/core';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { BooksRoutingModule } from './books-routing.module';
import { BooksComponent } from './books/books.component';
import { BookFormComponent } from './book-form/book-form.component';

@NgModule({
  declarations: [
    BooksComponent,
    BookFormComponent
  ],
  imports: [
    AppMaterialModule,
    BooksRoutingModule,
    SharedModule
  ]
})
export class BooksModule { }
