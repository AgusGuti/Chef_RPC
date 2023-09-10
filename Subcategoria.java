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
@Table(name = "dulces")
@Data @NoArgsConstructor
public class Subcategoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(name = "subcategoria", nullable = false)
	private String subcategoria;


	
	public Subcategoria(int id, String subcategoria) {
		
		this.id = id;
		this.subcategoria = subcategoria;
		
	}
	
	public Subcategoria(String subcategoria) {
		
		this.subcategoria = subcategoria;
		
	}

    @ManyToOne
    @JoinColumn(
            name = "categoria_id",
            referencedColumnName = "id"
    )
    private Categoria categoria;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    
}