package com.chefencasa.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.Seguido;
import com.chefencasa.app.entities.User;

@Repository("seguidoRepository")
public interface SeguidoRepository extends JpaRepository<Seguido, Serializable> {

    @Query("SELECT DISTINCT s FROM Seguido s WHERE s.user.id = :userId")
	public abstract List<Seguido> findAllSeguidosByUserId(@Param("userId") int userId);

    @Query("SELECT s FROM Seguido s WHERE (s.user.id LIKE :userId AND s.seguido.id LIKE :seguidoId)")
	public abstract Seguido validarCredenciales(@Param("userId") int userId, @Param("seguidoId") int seguidoId);


}
