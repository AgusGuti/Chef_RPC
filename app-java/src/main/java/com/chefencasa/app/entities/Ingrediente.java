package com.chefencasa.app.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
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

import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingrediente")
@Data @NoArgsConstructor
public class Ingrediente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	 @ManyToMany(cascade = {
	            CascadeType.PERSIST,
	            CascadeType.MERGE
	    })
	    @JoinTable(
	            name = "ingrediente_receta",
	            joinColumns = {@JoinColumn(name = "ingrediente_id")},
	            inverseJoinColumns = {@JoinColumn(name = "receta_id")}
	    )
	    private Set<Receta> recetas  = new HashSet<Receta>();


	@Column(name = "ingrediente", nullable = false)
	private String ingrediente;

	public Ingrediente(int id, String ingrediente) {
		
		this.id = id;
		this.ingrediente = ingrediente;
		
	}
	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return id == other.id && Objects.equals(ingrediente, other.ingrediente)
				&& Objects.equals(recetas, other.recetas);
	}

	public int hashCode() {
		return Objects.hash(ingrediente);
	}



	
	
	


    
}