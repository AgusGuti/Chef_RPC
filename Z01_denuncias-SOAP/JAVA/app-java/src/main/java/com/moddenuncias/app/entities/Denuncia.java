package com.moddenuncias.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Column;
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
@Table(name = "denuncia")
@Data @NoArgsConstructor
public class Denuncia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


	@ManyToOne(optional = false)
    @JoinColumn(name = "receta_id", nullable = false)
    private Receta receta;

	@Column(name = "motivo", nullable = false, length = 255)
	private String motivo;

	@Column(name = "resuelta", unique = true, nullable = false, length = 1)
	private String resuelta;

	

	public Denuncia(User user, Receta receta, String motivo) {
		this.user = user;
		this.receta = receta;
		this.motivo = motivo;
		this.resuelta = "0";
	}



	public Denuncia(int id, User user, Receta receta, String motivo, String resuelta) {
		this.id = id;
		this.user = user;
		this.receta = receta;
		this.motivo = motivo;
		this.resuelta = resuelta;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}