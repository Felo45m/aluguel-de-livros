package com.felo.loja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felo.loja.model.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findById(Long id);
	
}
