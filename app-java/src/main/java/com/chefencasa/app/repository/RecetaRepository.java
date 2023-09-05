package com.chefencasa.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.Receta;

@Repository("recetaRepository")
public interface RecetaRepository extends JpaRepository<Receta, Serializable> {

	public abstract List<Receta> findAll();
	
	public abstract List<Receta> findByUserId(int userId);

}