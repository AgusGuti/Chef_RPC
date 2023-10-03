package com.chefencasa.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.PopularidadUser;
import com.chefencasa.app.entities.User;


@Repository("popularidadUserRepository")
public interface PopularidadUserRepository extends JpaRepository<PopularidadUser, Serializable> {

    boolean existsByNombreUsuario(String nombreUsuario);

    @Query("SELECT pu FROM PopularidadUser pu WHERE pu.nombreUsuario = :nombreUsuario")
    PopularidadUser findByNombreUsuario(@Param("nombreUsuario") String nombreUsuario);

    @Query("SELECT p FROM PopularidadUser p WHERE p.user = :user")
    public abstract PopularidadUser findByUser(User user);

}