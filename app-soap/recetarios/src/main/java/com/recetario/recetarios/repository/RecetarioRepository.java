package com.recetario.recetarios.repository;

import java.io.Serializable;
import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recetario.recetarios.entities.Recetario;

@Repository("recetarioRepository")
public interface RecetarioRepository extends JpaRepository<Recetario, Serializable> {

    @Query("SELECT r FROM Recetario r WHERE r.id = :id")
    public abstract Recetario findById(int id);
    


    
}
