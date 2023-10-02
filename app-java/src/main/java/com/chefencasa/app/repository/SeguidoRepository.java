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

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Seguido s WHERE s.user = :user AND s.seguido = :seguido")
    boolean existsBySeguidoUser(@Param("user") User user, @Param("seguido") User seguido);
}
