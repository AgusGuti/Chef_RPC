package com.chefencasa.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PopularidadReceta")
@Data @NoArgsConstructor
public class PopularidadReceta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "receta_id", nullable = false)
    private Receta receta;

    @Column(name = "puntaje", nullable = false)
	private String puntaje;


	
	public PopularidadReceta(int id, String puntaje) {
		
		this.id = id;
        this.puntaje = puntaje;
		
	}
	

	public PopularidadReceta(Receta receta, String puntaje) {
		this.receta = receta;
		this.puntaje = puntaje;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    
}