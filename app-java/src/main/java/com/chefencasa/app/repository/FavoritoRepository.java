package com.chefencasa.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.Favorito;

@Repository("favoritoRepository")
public interface FavoritoRepository extends JpaRepository<Favorito, Serializable> {

	@Query("SELECT DISTINCT f FROM Favorito f WHERE f.user_id.id = :userId AND f.receta_id = :recetaId")
	public abstract Favorito checkFavorito(@Param("userId") int userId, @Param("recetaId") int recetaId);

}
