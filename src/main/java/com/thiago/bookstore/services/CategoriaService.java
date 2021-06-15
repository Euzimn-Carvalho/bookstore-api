package com.thiago.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.bookstore.domain.Categoria;
import com.thiago.bookstore.dtos.CategoriaDTO;
import com.thiago.bookstore.exceptions.ObjectNotFoundException;
import com.thiago.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria findOneCategoria(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado id: " + id + ", tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	public Categoria deleteCategoria(Integer id){
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrado id: " + id + ", tipo: " + Categoria.class.getName()));
	}
	
	public Categoria create(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}
	
	public Categoria update(Integer id, CategoriaDTO categoriaDTO) {
		Categoria categoria = this.findOneCategoria(id);
		categoria.setNome(categoriaDTO.getNome());
		categoria.setDescricao(categoriaDTO.getDescricao());
		
		return categoriaRepository.save(categoria);
	}
}
