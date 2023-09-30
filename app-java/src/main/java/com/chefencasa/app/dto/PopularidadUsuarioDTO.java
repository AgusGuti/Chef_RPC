package com.chefencasa.app.dto;

public class PopularidadUsuarioDTO {
    private String nombreUsuario;
    private String puntaje;
    
    
    public PopularidadUsuarioDTO(String nombreUsuario, String puntaje) {
        this.nombreUsuario = nombreUsuario;
        this.puntaje = puntaje;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }


    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public String getPuntaje() {
        return puntaje;
    }


    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }


    @Override
    public String toString() {
        return "PopularidadUsuarioDTO [nombreUsuario=" + nombreUsuario + ", puntaje=" + puntaje + "]";
    }

    
}
