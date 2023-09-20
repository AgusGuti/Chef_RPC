package com.chefencasa.app.entities;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "favorito")
@Data @NoArgsConstructor
public class Favorito implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;


	@ManyToOne(optional = false)
    @JoinColumn(name = "receta_id", nullable = false)
    private Receta receta_id;


	

	public Favorito(int id) {
		
		this.id = id;
		
	}

	public Favorito(int id, User user_id, Receta receta_id) {
		
		this.id = id;
		this.user_id = user_id;
		this.receta_id = receta_id;
	}

	public Favorito(User user_id, Receta receta_id) {
		this.user_id = user_id;
		this.receta_id = receta_id;		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    
}