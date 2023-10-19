package com.recetario.recetarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.recetario.recetarios.entities.Recetario;
import com.recetario.recetarios.repository.RecetarioRepository;

@Service("recetarioService")
public class RecetarioService {

    @Autowired
    @Qualifier("recetarioRepository") 
    private RecetarioRepository recetarioRepository;
    
    public Object addRecetario(String nombre, int usuariId) {
		return recetarioRepository.saveAndFlush(new Recetario(nombre, usuariId));
	}

    public void deleteRecetario(int attributeId) {
		recetarioRepository.delete(recetarioRepository.findById(attributeId));
	}

    public List<Recetario> TraerRecetarios(){
		return recetarioRepository.findAll();
	}

    public List<Recetario> TraerRecetariosPorUsuario(final int usuarioId) {
    return recetarioRepository.TraerRecetariosPorUsuario(usuarioId);
  }
    
}
