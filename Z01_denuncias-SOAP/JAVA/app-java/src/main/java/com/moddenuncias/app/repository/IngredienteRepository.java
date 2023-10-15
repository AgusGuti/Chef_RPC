package com.moddenuncias.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moddenuncias.app.entities.Ingrediente;

@Repository("ingredienteRepository")
public interface IngredienteRepository extends JpaRepository<Ingrediente, Serializable> {
	
	@EntityGraph(attributePaths = "recetas")
	public abstract Ingrediente findByNombre(String nombre);

	public abstract Ingrediente findById(int id);

}
