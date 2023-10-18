package com.moddenuncias.denuncias.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moddenuncias.denuncias.entities.Motivo;

@Repository("motivoRepository")
public interface MotivoRepository extends JpaRepository<Motivo, Serializable> {
	
    
    @Query("SELECT m FROM Motivo m WHERE m.id = :id")
    public abstract Motivo findById(int id);

}
