package com.moddenuncias.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moddenuncias.app.entities.Denuncia;
import com.moddenuncias.app.entities.Receta;

@Repository("denunciaRepository")
public interface DenunciaRepository extends JpaRepository<Denuncia, Serializable> {
	
	public abstract Denuncia findById(int id);

	@Query("SELECT d FROM Denuncia d WHERE d.resuelta = '0'")
	public abstract List<Denuncia> findUnresolved();

}
