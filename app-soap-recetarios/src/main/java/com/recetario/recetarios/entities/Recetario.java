package com.recetario.recetarios.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="Recetario")
public class Recetario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="usuarioId", nullable = false)
    private int usuarioId;

    public Recetario() {
    }

    public Recetario(String nombre, int usuarioId) {
        this.nombre = nombre;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para 'usuarioId'
    public int getUsuarioId() {
        return usuarioId;
    }

    // Setter para 'usuarioId'
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }


    @Override
    public String toString() {
        return "Recetario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", usuarioId='" + usuarioId + '\'' +
                '}';
    }
    
    
}
