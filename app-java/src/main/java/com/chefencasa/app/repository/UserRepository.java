package com.chefencasa.app.repository;

import java.io.Serializable;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.User;
import com.chefencasa.model.UserProto.Users;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {

	@Query("SELECT u FROM User u WHERE (u.nombre LIKE :nombre AND u.clave LIKE :clave) OR (u.email LIKE :email AND u.clave LIKE :clave)")
	public abstract User validarCredenciales(@Param("nombre") String nombre, @Param("email") String email,
			@Param("clave") String clave);
	
	public abstract User findById(int id);

	@Query("SELECT u FROM User u where u.id  IN (SELECT seg.seguido_id.id FROM Seguidos seg WHERE seg.user_id.id = :user_id) order by u.id ASC")
	public abstract java.util.List<User> findSeguidosById(@Param("user_id") int user_id);

	@Query("SELECT u FROM User u where u.id  IN (SELECT seg.user_id.id FROM Seguidos seg WHERE seg.seguido_id.id = :user_id) order by u.id ASC")
	public abstract java.util.List<User> findSeguidoresById(@Param("user_id") int user_id);

}