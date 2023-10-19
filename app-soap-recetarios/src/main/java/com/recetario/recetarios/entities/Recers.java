package com.recetario.recetarios.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="Recers")
public class Recers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference(value = "recetarioRecetas")
    @JoinColumn(name = "recetarioId")
    private Recetario recetario;

    @Column(name="recetaId", nullable = false)
    private int recetaId;


    // Constructor
    public Recers() {
    }

    public Recers(int recetaId, Recetario recetario) {  // Cambiar el orden de los argumentos
        this.recetario = recetario;
        this.recetaId = recetaId;
    }

    // Getter y Setter para 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public Recetario getRecetario() {
        return recetario;
    }

    public void setRecetario(Recetario recetario) {
        this.recetario = recetario;
    }

    // Getter y Setter para 'recetaId'
    public int getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(int recetaId) {
        this.recetaId = recetaId;
    }

    @Override
    public String toString() {
        return "Recers{" +
               "id=" + id +
               ", recetario=" + recetario +
               ", recetaId=" + recetaId +
               '}';
    }
    
    
}
