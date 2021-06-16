package com.thiago.bookstore.dtos;

import java.io.Serializable;

import com.thiago.bookstore.domain.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String titulo;
	private String nome_autor;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro livro) {
		super();
		this.titulo = livro.getTitulo();
		this.nome_autor = livro.getNome_autor();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}
}
