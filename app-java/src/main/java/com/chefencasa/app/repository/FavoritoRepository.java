package com.chefencasa.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.Favorito;
import com.chefencasa.app.entities.Receta;
import com.chefencasa.app.entities.User;

@Repository("favoritoRepository")
public interface FavoritoRepository extends JpaRepository<Favorito, Serializable> {
    
    public abstract List<Favorito> findAll();

    @Query("SELECT DISTINCT f FROM Favorito f LEFT JOIN FETCH f.receta r LEFT JOIN FETCH r.ingredientes WHERE f.user.id = :userId")
    public abstract List<Favorito> findAllFavoritosByUserId(@Param("userId") int userId);

    public abstract boolean existsByUserAndReceta(User user, Receta receta);


}
