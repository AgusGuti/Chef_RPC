package com.chefencasa.app.dto;

import java.io.Serializable;

public class PopularidadUserDTO implements Serializable{

    private String nombreUser;
    private int puntaje;
   
	
    
    public PopularidadUserDTO(String nombreUser, int puntaje) {
		this.nombreUser= nombreUser;
		this.puntaje = puntaje;
		
	}

	public PopularidadUserDTO() {
		super();
	}
	

	public String nombreUser() {
		return nombreUser;
	}


	public int getPuntaje() {
		return puntaje;
	}

	

	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}


	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public String toString() {
		
		return "PopularidadUserDTO [nombreUser=" + nombreUser + ", puntaje=" + puntaje + "]";
	}
	
}
