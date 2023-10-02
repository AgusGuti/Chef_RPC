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
@Table(name = "comentario")
@Data @NoArgsConstructor
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "usuarioComentario", nullable = false)
	private String usuarioComentario;

    @Column(name = "recetaComentada", nullable = false)
	private String recetaComentada;


	@Column(name = "comentario", nullable = false)
	private String comentario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "receta_id", nullable = false)
    private Receta receta;


	
	public Comentario(int id, String usuarioComentario, String recetaComentada, String comentario) {
		
		this.id = id;
        this.usuarioComentario = usuarioComentario;
        this.recetaComentada = recetaComentada;
		this.comentario = comentario;
		
	}
	
	public Comentario(String comentario) {
		
		this.comentario = comentario;
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    
}