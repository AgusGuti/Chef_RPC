package com.moddenuncias.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moddenuncias.app.entities.Categoria;

@Repository("categoriaRepository")
public interface CategoriaRepository extends JpaRepository<Categoria, Serializable> {

//	public abstract Categoria findByCategoria(int id); INUTILIZADO

}