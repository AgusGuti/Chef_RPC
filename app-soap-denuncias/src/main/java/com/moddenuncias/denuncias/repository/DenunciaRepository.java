package com.moddenuncias.denuncias.repository;

import java.io.Serializable;
import java.util.List;

//import org.springframework.data.jpa.repository.EntityGraph;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moddenuncias.denuncias.entities.Denuncia;
import com.moddenuncias.denuncias.entities.Motivo;


@Repository("denunciaRepository")
public interface DenunciaRepository extends JpaRepository<Denuncia, Serializable> {
	
    @Query("SELECT d FROM Denuncia d LEFT JOIN FETCH d.motivo_id m WHERE d.resuelta = '0'")
    public abstract List<Denuncia> findUnresolved();

    @Query("SELECT d FROM Denuncia d WHERE d.id = :id")
    public abstract Denuncia findById(int id);

    @Query("SELECT DISTINCT d.receta_id FROM Denuncia d WHERE d.resuelta = '0'")
    public abstract List<Integer> findRecetasIds();


}
