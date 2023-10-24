package com.example.demo.entity;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
    private Long id;
    private String name;

    
    

    public UsuarioDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    @Override
    public String toString() {
        return "UsuarioDTO [id=" + id + ", name=" + name + "]";
    }
    

    
    
}
