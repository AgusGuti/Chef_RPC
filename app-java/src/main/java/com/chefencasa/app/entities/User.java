package com.chefencasa.app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

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

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "email", unique = true, nullable = false, length = 45)
	private String email;

	@Column(name = "name", nullable = false, length = 60)
	private String name;


	@Column(name = "nick", nullable = false, length = 45)
	private String nick;

	@Column(name = "password", nullable = false, length = 45)
	private String password;


	@Column(name = "role", unique = true, nullable = false, length = 45)
	private String role;

	@Column(name = "surname", unique = true, nullable = false, length = 45)
	private String surname;

	public User(int id, String email, String name, String nick, String password, String role, String surname) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.nick = nick;
		this.password = password;
		this.role = role;
		this.surname = surname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    
}