package com.chefencasa.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	    private Set<Receta> recetas;


	@Column(name = "ingrediente", nullable = false)
	private String ingrediente;


	

	public Ingrediente(int id, String ingrediente) {
		
		this.id = id;
		this.ingrediente = ingrediente;
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    
}