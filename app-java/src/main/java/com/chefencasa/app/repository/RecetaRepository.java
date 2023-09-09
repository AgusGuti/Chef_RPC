package com.chefencasa.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.Receta;

@Repository("recetaRepository")
public interface RecetaRepository extends JpaRepository<Receta, Serializable>, JpaSpecificationExecutor<Receta> {

	public abstract List<Receta> findAll();
	
	public abstract List<Receta> findByUserId(int userId);
	
	public abstract Receta findById(int id);

}