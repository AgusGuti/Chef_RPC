package com.chefencasa.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.DigestUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rol")
@Data @NoArgsConstructor
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;

	@Column(name = "rol", unique = true, nullable = false, length = 45)
	private String rol;

	public Rol(int idRol, String rol) {
		this.idRol = idRol;
		this.rol = rol;

	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}