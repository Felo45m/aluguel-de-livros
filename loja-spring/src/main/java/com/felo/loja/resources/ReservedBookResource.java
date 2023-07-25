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

import com.felo.loja.model.entities.ReservedBook;
import com.felo.loja.services.ReservedBookService;

@RestController
@RequestMapping(value = "/api/reserved-book")
public class ReservedBookResource {
	
	@Autowired
	ReservedBookService reservedBookService;
	
	@GetMapping
	public ResponseEntity<List<ReservedBook>> findAll() {
		List<ReservedBook> List = reservedBookService.findAll();
		return ResponseEntity.ok().body(List);
	}
	
	@GetMapping(value = "/{id}")
	public Optional<ReservedBook> findById(@PathVariable(value = "id") Long id) {
		return reservedBookService.findById(id);
	}

	@PostMapping
	public ResponseEntity<ReservedBook> saveBook(@RequestBody ReservedBook reservedBook) {
		reservedBook = reservedBookService.save(reservedBook);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(reservedBook.getId()).toUri();
		return ResponseEntity.created(uri).body(reservedBook);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable(value = "id") Long id) {
		reservedBookService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
