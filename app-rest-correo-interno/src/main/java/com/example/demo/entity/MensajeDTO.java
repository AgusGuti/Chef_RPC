package com.example.demo.entity;

import java.io.Serializable;

public class MensajeDTO implements Serializable {
    private String asunto;
    private String cuerpo;
    private Long idEmisor;
    private Long idReceptor;

    

    public MensajeDTO(String asunto, String cuerpo, Long idEmisor, Long idReceptor) {
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.idEmisor = idEmisor;
        this.idReceptor = idReceptor;
    }

    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public String getCuerpo() {
        return cuerpo;
    }
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    public Long getIdEmisor() {
        return idEmisor;
    }
    public void setIdEmisor(Long idEmisor) {
        this.idEmisor = idEmisor;
    }
    public Long getIdReceptor() {
        return idReceptor;
    }
    public void setIdReceptor(Long idReceptor) {
        this.idReceptor = idReceptor;
    }

    @Override
    public String toString() {
        return "MensajeDTO {asunto=" + asunto + ", cuerpo=" + cuerpo + ", idEmisor=" + idEmisor + ", idReceptor="
                + idReceptor + "}";
    }

    
    
}
