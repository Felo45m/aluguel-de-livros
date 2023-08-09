import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { Book } from '../model/book';
import { BooksService } from './../services/books.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent {

  books: Observable<Book[]>;
  displayedColumns = ['title', 'author', 'price', 'actions'];

  constructor(
    private booksService: BooksService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.books = this.booksService.list()
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar livros.');
        return of([])
      })
    )
  }

  onAdd() {
    this.router.navigate(['new'], {relativeTo: this.route})
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

}
