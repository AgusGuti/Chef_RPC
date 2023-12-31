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
	
    @Query("SELECT d FROM Denuncia d LEFT JOIN FETCH d.motivo_id m WHERE d.resuelta <> '1'")
    public abstract List<Denuncia> findUnresolved();

    @Query("SELECT d FROM Denuncia d WHERE d.id = :id")
    public abstract Denuncia findById(int id);

    

    @Query("SELECT d FROM Denuncia d LEFT JOIN FETCH d.motivo_id m WHERE d.resuelta <> '1' AND d.receta_id = :receta_id")
    public abstract List<Denuncia> findByRecetaId(int receta_id);

}
