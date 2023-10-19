package com.recetario.recetarios.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="Recers")
public class Recers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="recetarioId", nullable = false)
    private int recetarioId;

    @Column(name="recetaId", nullable = false)
    private int recetaId;


    // Constructor
    public Recers() {
    }

    public Recers(int id, int recetarioId, int recetaId) {
        this.id = id;
        this.recetarioId = recetarioId;
        this.recetaId = recetaId;
    }

    // Getter y Setter para 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para 'recetarioId'
    public int getRecetarioId() {
        return recetarioId;
    }

    public void setRecetarioId(int recetarioId) {
        this.recetarioId = recetarioId;
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
        return "ReceRs [id=" + id + ", recetarioId=" + recetarioId + ", recetaId=" + recetaId + "]";
    }
    
    
}
