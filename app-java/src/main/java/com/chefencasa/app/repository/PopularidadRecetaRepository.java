package com.chefencasa.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.PopularidadReceta;
import com.chefencasa.app.entities.Receta;


@Repository("popularidadRecetaRepository")
public interface PopularidadRecetaRepository extends JpaRepository<PopularidadReceta, Serializable> {

    public abstract boolean existsByReceta(Receta receta);

    @Query("SELECT p FROM PopularidadReceta p LEFT JOIN FETCH p.receta r WHERE r.id = :idReceta")
    public abstract PopularidadReceta findByRecetaId(@Param("idReceta") int idReceta);

    @Query("SELECT p FROM PopularidadReceta p WHERE p.receta = :receta")
    public abstract PopularidadReceta findByReceta(Receta receta);

    @Query("SELECT p FROM PopularidadReceta p LEFT JOIN FETCH p.receta WHERE p.id = :id")
    public abstract PopularidadReceta findById(int id);


}