package com.chefencasa.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.Receta;

@Repository("recetaRepository")
public interface RecetaRepository extends JpaRepository<Receta, Serializable>, JpaSpecificationExecutor<Receta> {

	public abstract List<Receta> findAll();
	
	
	@Query("SELECT DISTINCT r FROM Receta r LEFT JOIN FETCH r.ingredientes")
	public abstract List<Receta> findAllRecetasIngredientes();

	@Query("SELECT DISTINCT r FROM Receta r LEFT JOIN FETCH r.ingredientes WHERE r.user.id IN (SELECT DISTINCT s.seguido.id FROM Seguido s WHERE s.user.id = :userId) ORDER BY r.fechaCreacion DESC")
	public abstract List<Receta> findAllRecetasSeguidos(int userId);

	public abstract List<Receta> findByUserIdOrderByFechaCreacionDesc(int userId);
	
	@Query("SELECT r FROM Receta r LEFT JOIN FETCH r.ingredientes LEFT JOIN FETCH r.categoria WHERE r.id = :id")
	public abstract Receta findById(int id);
	
	@Query("SELECT DISTINCT r FROM Receta r LEFT JOIN FETCH r.ingredientes WHERE r.user.id = :userId ORDER BY r.fechaCreacion DESC")
	public abstract List<Receta> findAllRecetasByUserId(@Param("userId") int userId);

}