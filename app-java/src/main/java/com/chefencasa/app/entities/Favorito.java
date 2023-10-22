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
    private User user;


	@ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "receta_id", nullable = false)
    private Receta receta;


	

	public Favorito(int id) {
		
		this.id = id;
		
	}

	

	public Favorito(int id, User user, Receta receta) {
		this.id = id;
		this.user = user;
		this.receta = receta;
	}

	


	public Favorito(User user, Receta receta) {
		this.user = user;
		this.receta = receta;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    
}