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

	public abstract List<Receta> findByUserIdOrderByFechaCreacionDesc(int userId);
	
	public abstract Receta findById(int id);
	
	@Query("SELECT r FROM Receta r WHERE r.user.id IN (SELECT s.seguido_id.id FROM Seguidos s WHERE s.user_id.id = :userId) ORDER BY r.fechaCreacion DESC")
	public abstract List<Receta> findAllRecetasOfSeguidosByUserId(@Param("userId") int userId);
	
	@Query("SELECT f.receta_id FROM Favorito f WHERE f.user_id.id = :userId ORDER BY f.receta_id.fechaCreacion DESC")
	public abstract List<Receta> findAllFavoritosByUserId(@Param("userId") int userId);

}