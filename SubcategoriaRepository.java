package com.chefencasa.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.Subcategoria;
import java.util.List;

@Repository("subcategoriaRepository")
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Serializable> {

	public abstract Subcategoria findByCategoria(String subcategoria);
    List<Subcategoria> findAllByMarca(Subcategoria subcategoria);

}