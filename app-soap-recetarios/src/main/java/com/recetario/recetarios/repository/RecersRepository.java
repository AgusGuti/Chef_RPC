package com.recetario.recetarios.repository;

import java.io.Serializable;
import java.util.List;

import com.recetario.recetarios.entities.Recers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;

@Repository("recersRepository")
public interface RecersRepository extends JpaRepository<Recers, Serializable> {

   
    @Query("SELECT r FROM Recers r WHERE r.recetarioId = :recetarioId")
    public List<Recers> TraerRecetasPorRecetario(@Param("recetarioId") int recetarioId);
    
    @Modifying
    @Query("DELETE FROM Recers r WHERE r.recetarioId = :recetarioId")
    public void eliminarRecetarios(@Param("recetarioId") int recetarioId);
}
