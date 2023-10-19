package com.moddenuncias.denuncias.entities;

import java.io.Serializable;

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
@Table(name = "motivo")
@Data@NoArgsConstructor
public class Motivo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "motivo", nullable = false, length = 255)
	private String motivo;
    

	public Motivo(String motivo) {
        this.motivo = motivo;
    }


    public Motivo(int id, String motivo) {
        this.id = id;
        this.motivo = motivo;
    }


    public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
    
