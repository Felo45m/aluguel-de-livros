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

import com.felo.loja.model.entities.Client;
import com.felo.loja.services.ClientService;

@RestController
@RequestMapping(value = "/api/clients")
public class ClienteResource {

	@Autowired
	ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> List = clientService.findAll();
		return ResponseEntity.ok().body(List);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Client client = clientService.findById(id);
		return ResponseEntity.ok().body(client);
	}
	
	@PostMapping
	public ResponseEntity<Client> saveClient(@RequestBody Client book) {
		book = clientService.insert(book);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(book.getId()).toUri();
		return ResponseEntity.created(uri).body(book);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
		client = clientService.update(id, client);
		return ResponseEntity.ok().body(client);
	}
}
