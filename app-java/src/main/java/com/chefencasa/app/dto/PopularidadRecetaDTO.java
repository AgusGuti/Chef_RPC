package com.chefencasa.app.dto;

public class PopularidadRecetaDTO {
    private int idReceta;
    private String puntaje;
    
    
    public PopularidadRecetaDTO(int idReceta, String puntaje) {
        this.idReceta = idReceta;
        this.puntaje = puntaje;
    }


    public int getIdReceta() {
        return idReceta;
    }


    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }


    public String getPuntaje() {
        return puntaje;
    }


    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }


    @Override
    public String toString() {
        return "PopularidadRecetaDTO [idReceta=" + idReceta + ", puntaje=" + puntaje + "]";
    }

    
}
