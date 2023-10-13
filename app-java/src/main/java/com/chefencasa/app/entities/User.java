package com.chefencasa.app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.DigestUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data @NoArgsConstructor
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre", nullable = false, length = 60)
	private String nombre;

	@Column(name = "apellido", nullable = false, length = 45)
	private String apellido;

	@Column(name = "email", unique = true, nullable = false, length = 45)
	private String email;

	@Column(name = "clave", nullable = false, length = 45)
	private String clave;

	@Column(name = "fotoPerfil", nullable = false, length = 255, columnDefinition = "VARCHAR(255) DEFAULT ''")
	private String fotoPerfil;

	@Column(name = "moderador", nullable = false, length = 1, columnDefinition = "VARCHAR(1) DEFAULT '0'")
	private String moderador;

	public User(int id, String nombre, String apellido, String email, String clave, String fotoPerfil,
			String moderador) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.clave = clave;
		this.fotoPerfil = fotoPerfil;
		this.moderador = moderador;
	}

	public User(int id, String nombre, String apellido, String email, String clave, String fotoPerfil) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.clave = clave;
		this.fotoPerfil = fotoPerfil;
		this.moderador = "0";
	}

	public User(String nombre, String apellido, String email, String clave, String fotoPerfil) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.clave = clave;
		this.fotoPerfil = fotoPerfil;
		this.moderador = "0";
	}

	public User(String nombre, String apellido, String email, String clave) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.clave = clave;
		this.fotoPerfil = "";
		this.moderador = "0";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	

}