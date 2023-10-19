package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mensaje {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.PROTECTED)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private Tipo tipoMensaje;

	@Column(name = "asunto", nullable = false, length = 50)
	private String asunto;

	@Column(name = "cuerpo", nullable = false, length = 500)
	private String cuerpo;

	@Column(name = "fechaHora")
	private LocalDateTime fechaHora;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Usuario emisor;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Usuario receptor;

	@JsonBackReference
	@OneToOne(optional = true)
	private Mensaje respuesta;

	public Mensaje(Tipo tipoMensaje, String asunto, String cuerpo, LocalDateTime fechaHora, Usuario emisor,
			Usuario receptor, Mensaje respuesta) {
		super();
		this.tipoMensaje = tipoMensaje;
		this.asunto = asunto;
		this.cuerpo = cuerpo;
		this.fechaHora = fechaHora;
		this.emisor = emisor;
		this.receptor = receptor;
		this.respuesta = respuesta;
	}
}