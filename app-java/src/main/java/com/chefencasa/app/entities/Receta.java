package com.chefencasa.app.entities;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "receta")
@Data
@NoArgsConstructor
public class Receta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@NotNull(message = "Campo requerido.")
	private User user;

	@JsonIgnore
	@ManyToMany(mappedBy = "recetas")
	private Set<Ingrediente> ingredientes;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;


	@Column(name = "tituloReceta", nullable = false, length = 100)
	private String tituloReceta;

	@Column(name = "descripcion", nullable = false, length = 1000)

	private String descripcion;

	@Column(name = "pasos", nullable = false)
	private String pasos;

	@Column(name = "tiempoPreparacion", nullable = false)
	private int tiempoPreparacion;

	@Column(name = "fechaCreacion", unique = true, nullable = false)
	private LocalDateTime fechaCreacion;

	@Column(name = "foto1", nullable = true)
	private String foto1;

	@Column(name = "foto2", nullable = true)
	private String foto2;

	@Column(name = "foto3", nullable = true)
	private String foto3;

	@Column(name = "foto4", nullable = true)
	private String foto4;

	@Column(name = "foto5", nullable = true)
	private String foto5;

	public Receta(int id, String tituloReceta, String descripcion, String pasos, int tiempoPreparacion, String foto1,
			String foto2, String foto3, String foto4, String foto5) {

		this.id = id;
		this.tituloReceta = tituloReceta;
		this.descripcion = descripcion;
		this.pasos = pasos;
		this.tiempoPreparacion = tiempoPreparacion;
		this.fechaCreacion = fechaCreacion;
		this.foto1 = foto1;
		this.foto2 = foto2;
		this.foto3 = foto3;
		this.foto4 = foto4;
		this.foto5 = foto5;
	}

	public Receta(User usuario, Set<Ingrediente> ingredientes, Categoria categoria, String tituloReceta, String descripcion, String pasos, int tiempoPreparacion, LocalDateTime fechaCreacion, String foto1,
			String foto2, String foto3, String foto4, String foto5) {

		this.user = usuario;
		this.setIngredientes(ingredientes);
		this.categoria = categoria;
		this.tituloReceta = tituloReceta;
		this.descripcion = descripcion;
		this.pasos = pasos;
		this.tiempoPreparacion = tiempoPreparacion;
		this.fechaCreacion = fechaCreacion;
		this.foto1 = foto1;
		this.foto2 = foto2;
		this.foto3 = foto3;
		this.foto4 = foto4;
		this.foto5 = foto5;
	}
	
	public Receta(User usuario, Categoria categoria, String tituloReceta, String descripcion, String pasos, int tiempoPreparacion, LocalDateTime fechaCreacion, String foto1,
			String foto2, String foto3, String foto4, String foto5) {

		this.user = usuario;
		this.categoria = categoria;
		this.tituloReceta = tituloReceta;
		this.descripcion = descripcion;
		this.pasos = pasos;
		this.tiempoPreparacion = tiempoPreparacion;
		this.fechaCreacion = fechaCreacion;
		this.foto1 = foto1;
		this.foto2 = foto2;
		this.foto3 = foto3;
		this.foto4 = foto4;
		this.foto5 = foto5;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}