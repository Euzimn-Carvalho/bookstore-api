package com.thiago.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.bookstore.domain.Livro;
import com.thiago.bookstore.services.LivroServices;

@RestController
@RequestMapping("/livros")
public class LivroResource {

	@Autowired
	private LivroServices services;
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> getById(@PathVariable Integer id){
		Livro livro = services.getById(id);
		return ResponseEntity.ok().body(livro);
	}
}
