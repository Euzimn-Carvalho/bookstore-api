package com.thiago.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.bookstore.domain.Categoria;
import com.thiago.bookstore.dtos.CategoriaDTO;
import com.thiago.bookstore.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResources {

	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getOneCategoria(@PathVariable Integer id) {
		Categoria categoria = categoriaService.findOneCategoria(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> getAllCategoria(){
		List<Categoria> listCategoria = categoriaService.findAll();
		List<CategoriaDTO> categoriaDTO = listCategoria.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriaDTO);
		
	}
}