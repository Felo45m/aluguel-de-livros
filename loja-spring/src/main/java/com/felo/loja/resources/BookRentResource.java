package com.felo.loja.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felo.loja.model.entities.BookRent;
import com.felo.loja.services.BookRentService;

@RestController
@RequestMapping(value = "/api/book-rental")
public class BookRentResource {
	
	@Autowired
	BookRentService bookRentService;
	
	@GetMapping
	public ResponseEntity<List<BookRent>> findAll() {
		List<BookRent> List = bookRentService.findAll();
		return ResponseEntity.ok().body(List);
	}
	
	@GetMapping(value = "/{id}")
	public Optional<BookRent> findById(@PathVariable(value = "id") Long id) {
		return bookRentService.findById(id);
	}

	@PostMapping
	public ResponseEntity<BookRent> saveBook(@RequestBody BookRent bookRent) {
		bookRent = bookRentService.save(bookRent);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(bookRent.getId()).toUri();
		return ResponseEntity.created(uri).body(bookRent);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable(value = "id") Long id) {
		bookRentService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
