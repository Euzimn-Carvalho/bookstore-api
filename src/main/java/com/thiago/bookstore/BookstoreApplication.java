package com.thiago.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thiago.bookstore.domain.Categoria;
import com.thiago.bookstore.domain.Livro;
import com.thiago.bookstore.repositories.CategoriaRepository;
import com.thiago.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired 
	private LivroRepository livroRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria = new Categoria(null, "Informática", "Livros de TI");
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", categoria);
		
		categoria.getListLivros().addAll(Arrays.asList(l1));
		this.categoriaRepository.saveAll(Arrays.asList(categoria));
		
		this.livroRepository.saveAll(Arrays.asList(l1));	
	}
}
