import { BooksService } from 'src/app/services/books.service';
import { IBook } from './../../intefaces/book';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  constructor(private bookService: BooksService) {}

  books: IBook[] = [];

  ngOnInit(): void {
    this.listBooks();
  }

  listBooks() {
    this.bookService.listBooks().subscribe((books: IBook[]) => {
      this.books = books;
    })
  }

}
