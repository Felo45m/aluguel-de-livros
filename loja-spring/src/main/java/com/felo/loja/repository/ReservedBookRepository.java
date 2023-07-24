package com.felo.loja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felo.loja.model.entities.ReservedBook;

public interface ReservedBookRepository extends JpaRepository<ReservedBook, Long> {

	Optional<ReservedBook> findById(Long id);
	
}
