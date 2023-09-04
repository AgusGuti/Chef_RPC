package com.chefencasa.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {

	@Query("SELECT u FROM User u WHERE (u.name LIKE :name AND u.password LIKE :password) OR (u.email LIKE :email AND u.password LIKE :password)")
	public abstract User validarCredenciales(@Param("name") String name, @Param("email") String email,
			@Param("password") String password);

}