package com.example.demo.entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }		
   

}
