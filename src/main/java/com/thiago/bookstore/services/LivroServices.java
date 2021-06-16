package com.thiago.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.bookstore.domain.Categoria;
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
	
	public Livro update(Integer id, Livro updateLivro) {
		Livro livro = this.getById(id);
		updateLivro(livro, updateLivro);
		return repository.save(livro);
	}
	
	private void updateLivro(Livro livro, Livro updateLivro) {
		livro.setTitulo(updateLivro.getTitulo());
		livro.setNome_autor(updateLivro.getNome_autor());
		livro.setTexto(updateLivro.getTexto());
	}
	
	public Livro create(Integer categoria_id, Livro livro) {
		Categoria categoria = categoriaService.findOneCategoria(categoria_id);
		livro.setId(null);
		livro.setCategoria(categoria);
		return repository.save(livro);
	}
}
