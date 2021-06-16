package com.thiago.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thiago.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
	
	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :categoria_id")
	public List<Livro> findLivrosByCategoria(@Param(value = "categoria_id") Integer categoria_id);
}
