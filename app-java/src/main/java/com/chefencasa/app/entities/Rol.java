package com.chefencasa.app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rol")
@Data @NoArgsConstructor
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "rol", unique = true, nullable = false, length = 45)
	private String rol;

	public Rol(int id, String rol) {
		this.id = id;
		this.rol = rol;

	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}