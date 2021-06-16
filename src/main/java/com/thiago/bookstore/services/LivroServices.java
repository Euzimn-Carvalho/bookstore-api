package com.thiago.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.bookstore.domain.Livro;
import com.thiago.bookstore.repositories.LivroRepository;
import com.thiago.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroServices {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro getById(Integer id) {
		Optional<Livro> livro = repository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException("Não existe livro para o id: " + id + ". Tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> findAllByCategoria(Integer categoria_id){
		categoriaService.findOneCategoria(categoria_id);
		return repository.findLivrosByCategoria(categoria_id);
	}
}
