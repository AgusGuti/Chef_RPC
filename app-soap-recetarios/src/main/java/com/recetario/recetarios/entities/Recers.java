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

    @Column(name = "recetarioId")
    private int recetarioId;

    @Column(name="recetaId", nullable = false)
    private int recetaId;


    // Constructor
    public Recers() {
    }

    public Recers(int recetaId, int recetarioId) {
        this.recetarioId = recetarioId;
        this.recetaId = recetaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecetarioId() {
        return recetarioId;
    }

    public void setRecetarioId(int recetarioId) {
        this.recetarioId = recetarioId;
    }

    public int getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(int recetaId) {
        this.recetaId = recetaId;
    }

    @Override
    public String toString() {
        return "Recers [id=" + id + ", recetarioId=" + recetarioId + ", recetaId=" + recetaId + "]";
    }

    
}
