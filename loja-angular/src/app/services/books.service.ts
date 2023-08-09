import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { IBook } from '../intefaces/book';

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  private readonly API = 'api/books'

  constructor(private http: HttpClient) { }

  listBooks() {
    return this.http.get<IBook[]>(this.API)
  }
}
