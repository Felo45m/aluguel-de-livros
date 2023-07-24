package com.felo.loja.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_BOOK_RENTAL")
public class BookRent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long ClientId;
	private Long BookId;
	private LocalDateTime now = LocalDateTime.now();
	
	public BookRent() {
		
	}

	public BookRent(Long id, Long clientId, Long bookId, LocalDateTime now) {
		this.id = id;
		ClientId = clientId;
		BookId = bookId;
		this.now = now;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return ClientId;
	}

	public void setClientId(Long clientId) {
		ClientId = clientId;
	}

	public Long getBookId() {
		return BookId;
	}

	public void setBookId(Long bookId) {
		BookId = bookId;
	}

	public LocalDateTime getNow() {
		return now;
	}

	public void setNow(LocalDateTime now) {
		this.now = now;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookRent other = (BookRent) obj;
		return Objects.equals(id, other.id);
	}

}
