package com.chefencasa.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.Comentario;


@Repository("comentarioRepository")
public interface ComentarioRepository extends JpaRepository<Comentario, Serializable> {
    
    @Query("SELECT DISTINCT c FROM Comentario c LEFT JOIN c.receta r WHERE r.id = :recetaId")
    public abstract List<Comentario> findByRecetaRecetaId(@Param("recetaId") int recetaId);


}