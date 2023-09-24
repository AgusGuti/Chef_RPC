package com.chefencasa.app.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "seguido")
@Data @NoArgsConstructor
public class Seguido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "seguido_id", nullable = false)
	private User seguido;

	
	public Seguido(int id, User user, User seguido) {
		this.id = id;
		this.user = user;
		this.seguido = seguido;
	}


	public Seguido(User user, User seguido) {
		this.user = user;
		this.seguido = seguido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}