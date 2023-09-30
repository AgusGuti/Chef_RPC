package com.chefencasa.app.dto;

import java.io.Serializable;

public class PopularidadRecetaDTO implements Serializable{

    private int idReceta;
    private int puntaje;
   
	
    
    public PopularidadRecetaDTO(int idReceta, int puntaje) {
		this.idReceta = idReceta;
		this.puntaje = puntaje;
		
	}

	public PopularidadRecetaDTO() {
		super();
	}
	

	public int getIdReceta() {
		return idReceta;
	}


	public int getPuntaje() {
		return puntaje;
	}

	

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}


	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public String toString() {
		
		return "NovedadesDTO [idReceta=" + idReceta + ", puntaje=" + puntaje + "]";
	}
	
}
