package com.felo.loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felo.loja.model.entities.Book;
import com.felo.loja.model.entities.ReservedBook;
import com.felo.loja.model.enums.Status;
import com.felo.loja.repository.BookRepository;
import com.felo.loja.repository.ReservedBookRepository;
import com.felo.loja.services.exceptions.ResourceNotFoundException;

@Service
public class ReservedBookService {

	@Autowired
	ReservedBookRepository reservedBookRepository;
	
	@Autowired 
	BookRepository bookRepository;
	
	public List<ReservedBook> findAll() {
		return reservedBookRepository.findAll();
	}

	public Optional<ReservedBook> findById (Long id) {
		Optional<ReservedBook> reservedBook = reservedBookRepository.findById(id);
		if (reservedBook == null) {
			throw new ResourceNotFoundException("Recurso não encontrado!");
		}
		return reservedBook;
	}	
	
	public ReservedBook save(ReservedBook reservedBook) {
		Optional<Book> book = bookRepository.findById(reservedBook.getBookId());
		if(book.get().getStatus()==Status.DISPONIVEL) {
			book.get().setStatus(Status.INDISPONIVEL);
			return reservedBookRepository.save(reservedBook);
		}
		throw new ResourceNotFoundException("Recurso invalido");
	}
	
	public void delete(Long id) {
		Optional<ReservedBook> bookRent = findById(id);
		Optional<Book> book = bookRepository.findById(bookRent.get().getBookId());
		book.get().setStatus(Status.DISPONIVEL);
		
		reservedBookRepository.deleteById(id);
	}
}
