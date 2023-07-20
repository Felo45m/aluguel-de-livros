package com.felo.loja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felo.loja.model.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Optional<Book> findById(Long id);
}
