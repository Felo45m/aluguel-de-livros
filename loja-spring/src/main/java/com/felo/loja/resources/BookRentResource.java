package com.felo.loja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felo.loja.services.BookRentService;

@RestController
@RequestMapping(value = "/api")
public class BookRentResource {
	
	@Autowired
	BookRentService bookRentService;

}
