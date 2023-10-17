package com.moddenuncias.denuncias.entities;

import java.io.Serializable;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "denuncia")
@Data@NoArgsConstructor
public class Denuncia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user_id", nullable = false)
    private int user_id;

	@Column(name = "receta_id", nullable = false)
    private int receta_id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "motivo_id", nullable = false)
	private Motivo motivo_id;

	@Column(name = "resuelta", nullable = false, length = 1)
	private String resuelta;
	
		
	public Denuncia(int user_id, int receta_id, Motivo motivo_id) {
		this.user_id = user_id;
		this.receta_id = receta_id;
		this.motivo_id = motivo_id;
		this.resuelta = "0";
	}	

	public Denuncia(int id, int user_id, int receta_id, Motivo motivo_id, String resuelta) {
		this.id = id;
		this.user_id = user_id;
		this.receta_id = receta_id;
		this.motivo_id = motivo_id;
		this.resuelta = resuelta;	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}