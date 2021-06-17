package com.thiago.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thiago.bookstore.domain.Livro;
import com.thiago.bookstore.dtos.LivroDTO;
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
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAllByCategoria(@RequestParam(value="categoria", defaultValue = "0") Integer categoria_id){
		List<Livro> listLivro = services.findAllByCategoria(categoria_id);
		return ResponseEntity.ok().body(listLivro.stream().map( livro -> new LivroDTO(livro) ).collect(Collectors.toList()));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @Valid @RequestBody Livro livro){
		Livro newLivro = services.update(id, livro);
		return ResponseEntity.ok().body(newLivro);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @Valid @RequestBody Livro livro){
		Livro newLivro = services.update(id, livro);
		return ResponseEntity.ok().body(newLivro);
	}
	
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value="categoria", defaultValue = "0") Integer categoria_id, @Valid @RequestBody Livro livro){
		Livro newLivro = services.create(categoria_id, livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newLivro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
}
