package com.felo.loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felo.loja.model.entities.Book;
import com.felo.loja.model.entities.BookRent;
import com.felo.loja.model.enums.Status;
import com.felo.loja.repository.BookRentRepository;
import com.felo.loja.repository.BookRepository;
import com.felo.loja.services.exceptions.ResourceNotFoundException;

@Service
public class BookRentService {
	
	@Autowired
	BookRentRepository bookRentRepository;
	
	@Autowired 
	BookRepository bookRepository;
	
	public List<BookRent> findAll() {
		return bookRentRepository.findAll();
	}

	public Optional<BookRent> findById (Long id) {
		Optional<BookRent> rentedBook = bookRentRepository.findById(id);
		if (rentedBook == null) {
			throw new ResourceNotFoundException("Recurso não encontrado!");
		}
		return rentedBook;
	}	
	
	public BookRent save(BookRent bookRent) {
		Optional<Book> book = bookRepository.findById(bookRent.getBookId());
		if(book.get().getStatus()==Status.AVAILABLE) {
			book.get().setStatus(Status.UNAVAILABLE);
			return bookRentRepository.save(bookRent);
		}
		throw new ResourceNotFoundException("Recurso invalido");
	}
	
	public void delete(Long id) {
		Optional<BookRent> bookRent = findById(id);
		Optional<Book> book = bookRepository.findById(bookRent.get().getBookId());
		book.get().setStatus(Status.AVAILABLE);
		
		bookRentRepository.deleteById(id);
	}
	
}
