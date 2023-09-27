package com.chefencasa.app.dto;

import java.io.Serializable;

public class NovedadesDTO implements Serializable{

    private String nombreUsuario;
    private String tituloReceta;
    private String foto1;
	
    
    public NovedadesDTO(String nombreUsuario, String tituloReceta, String foto1) {
		this.nombreUsuario = nombreUsuario;
		this.tituloReceta = tituloReceta;
		this.foto1 = foto1;
	}

	public NovedadesDTO() {
		super();
	}
	

	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public String getTituloReceta() {
		return tituloReceta;
	}


	public String getFoto1() {
		return foto1;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public void setTituloReceta(String tituloReceta) {
		this.tituloReceta = tituloReceta;
	}


	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}

	@Override
	public String toString() {
		return "NovedadesDTO [nombreUsuario=" + nombreUsuario + ", tituloReceta=" + tituloReceta + ", foto1=" + foto1
				+ "]";
	}
	
}
