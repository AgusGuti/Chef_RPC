package com.chefencasa.app.dto;

import java.io.Serializable;

public class ComentarioDTO implements Serializable{

    private String usuarioComentario;
    private String recetaComentada;
    private String comentario;
	
    
    public ComentarioDTO(String usuarioComentario, String recetaComentada, String comentario) {
		this.usuarioComentario = usuarioComentario;
		this.recetaComentada = recetaComentada;
		this.comentario = comentario;
	}

	public ComentarioDTO() {
		super();
	}
	

	public String getUsuarioComentario() {
		return usuarioComentario;
	}


	public String getRecetaComentada() {
		return recetaComentada;
	}


	public String getComentario() {
		return comentario;
	}


	public void setUsuarioComentario(String usuarioComentario) {
		this.usuarioComentario = usuarioComentario;
	}


	public void setRecetaComentada(String recetaComentada) {
		this.recetaComentada = recetaComentada;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "ComentarioDTO [usuarioComentario=" + usuarioComentario + ", recetaComentada=" + recetaComentada + ", comentario=" + comentario
				+ "]";
	}
	
}