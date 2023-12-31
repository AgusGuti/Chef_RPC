package com.chefencasa.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.Categoria;

@Repository("categoriaRepository")
public interface CategoriaRepository extends JpaRepository<Categoria, Serializable> {

//	public abstract Categoria findByCategoria(int id); INUTILIZADO

}