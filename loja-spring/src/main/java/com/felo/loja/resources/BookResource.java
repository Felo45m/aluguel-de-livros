package com.felo.loja.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felo.loja.model.entities.Book;
import com.felo.loja.services.BookService;

@RestController
@RequestMapping(value = "/api")
public class BookResource {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> findAll() {
		List<Book> List = bookService.findAll();
		return ResponseEntity.ok().body(List);
	}
	
	@GetMapping(value = "/book/{id}")
	public ResponseEntity<Book> findById(@PathVariable(value = "id") Long id) {
		Book book = bookService.findById(id);
		return ResponseEntity.ok().body(book);
	}
	
	@PostMapping("/book")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		book = bookService.save(book);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(book.getId()).toUri();
		return ResponseEntity.created(uri).body(book);
	}
	
	@DeleteMapping(value = "/book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable(value = "id") Long id) {
		bookService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/book")
	public Book updateBook(@RequestBody Book book) {
		return bookService.save(book);
	}
	
	@GetMapping("/book-availables")
	public List<Book> booksAvailables() {
		return bookService.available();
	}
	
	@GetMapping("/book-unavailables")
	public List<Book> booksUnavailables() {
		return bookService.unavailable();
	}
	
}
