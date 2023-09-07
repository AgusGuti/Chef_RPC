package com.chefencasa.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.Ingrediente;

@Repository("ingredienteRepository")
public interface IngredienteRepository extends JpaRepository<Ingrediente, Serializable> {
	
	@EntityGraph(attributePaths = "recetas")
	public abstract Ingrediente findByIngrediente(String ingrediente);

}
