package com.chefencasa.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chefencasa.app.entities.Receta;


@Repository("recetaRepository")
public interface RecetaRepository extends JpaRepository<Receta, Serializable>, JpaSpecificationExecutor<Receta> {


	
	public abstract List<Receta> findAll();
	
	
	@Query("SELECT DISTINCT r FROM Receta r LEFT JOIN FETCH r.ingredientes WHERE r.baja <> '1'")
	public abstract List<Receta> findAllRecetasIngredientes();

	public abstract List<Receta> findByUserIdOrderByFechaCreacionDesc(int userId);
	
	@Query("SELECT r FROM Receta r LEFT JOIN FETCH r.ingredientes LEFT JOIN FETCH r.categoria WHERE r.id = :id AND r.baja <> '1'")
	public abstract Receta findById(int id);
	
	@Query("SELECT DISTINCT r FROM Receta r LEFT JOIN FETCH r.ingredientes WHERE r.user.id = :userId AND r.baja <> '1' ORDER BY r.fechaCreacion DESC")
	public abstract List<Receta> findAllRecetasByUserId(@Param("userId") int userId);
	
	@Query("SELECT r FROM Receta r WHERE r.tituloReceta = :tituloReceta AND r.baja <> '1'")
	Receta findByTituloReceta(String tituloReceta);

	


}