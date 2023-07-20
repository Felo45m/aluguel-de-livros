package com.felo.loja.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.felo.loja.model.entities.Book;
import com.felo.loja.model.enums.Status;
import com.felo.loja.repository.BookRepository;
import com.felo.loja.services.exceptions.DatabaseException;
import com.felo.loja.services.exceptions.ResourceNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	public Book findById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		return book.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public void delete(Long id) {
		try {
			bookRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public List<Book> available() {
		List<Book> listBook = new ArrayList<Book>();
		for(Book book : bookRepository.findAll()) {
			if (book.getStatus()==Status.AVAILABLE) {
				listBook.add(book);
			}
		}
		return listBook;
	}
	
	public List<Book> unavailable() {
		List<Book> listBook = new ArrayList<Book>();
		for(Book book : bookRepository.findAll()) {
			if (book.getStatus()==Status.UNAVAILABLE) {
				listBook.add(book);
			}
		}
		return listBook;
	}

}
