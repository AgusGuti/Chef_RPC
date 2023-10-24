package com.chefencasa.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {

	@Query("SELECT u FROM User u WHERE (u.nombre LIKE :nombre AND u.clave LIKE :clave) OR (u.email LIKE :email AND u.clave LIKE :clave)")
	public abstract User validarCredenciales(@Param("nombre") String nombre, @Param("email") String email,
			@Param("clave") String clave);
	
	public abstract User findById(int id);

	User findByNombre(String nombre);

	
	@Query("SELECT u FROM User u WHERE u.email LIKE :email ")
	public abstract User findByEmail (@Param("email") String email);

}