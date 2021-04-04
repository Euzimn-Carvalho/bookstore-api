package com.thiago.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.bookstore.domain.Categoria;
import com.thiago.bookstore.domain.Livro;
import com.thiago.bookstore.repositories.CategoriaRepository;
import com.thiago.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired 
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		
		Categoria c1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria c2 = new Categoria(null, "Ficção Científica", "Livros de Terror");
		Categoria c3 = new Categoria(null, "Biografias", "Livros de pessoas");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", c1);
		Livro l2 = new Livro(null, "Constante é constante", "Hcode", "Lorem Ipsum", c1);
		Livro l3 = new Livro(null, "It a coisa", "Stephen King", "Palhaço Gay", c2);
		Livro l4 = new Livro(null, "Casa dos Horrores", "Maria Feia", "Casa do mal", c2);
		
		
		c1.getListLivros().addAll(Arrays.asList(l1, l2));
		c2.getListLivros().addAll(Arrays.asList(l4, l3));
		
		this.categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
		this.livroRepository.saveAll((Arrays.asList(l1, l2, l3, l4)));
		
	}
}
