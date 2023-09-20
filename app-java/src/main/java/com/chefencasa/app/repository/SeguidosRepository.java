package com.chefencasa.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.Receta;
import com.chefencasa.app.entities.Seguidos;

@Repository("seguidosRepository")
public interface SeguidosRepository extends JpaRepository<Seguidos, Serializable> {

	@Query("SELECT DISTINCT s FROM Seguidos s WHERE s.user_id.id = :userId AND s.seguido_id = :seguidoId")
	public abstract Seguidos checkSeguidos(@Param("userId") int userId, @Param("seguidoId") int seguidoId);

}
