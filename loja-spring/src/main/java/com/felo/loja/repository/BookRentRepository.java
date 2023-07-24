package com.felo.loja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felo.loja.model.entities.BookRent;

public interface BookRentRepository extends JpaRepository<BookRent, Long> {

	Optional<BookRent> findById(Long id);
}
