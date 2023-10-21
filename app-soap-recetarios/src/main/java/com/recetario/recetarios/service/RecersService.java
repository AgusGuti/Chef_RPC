package com.recetario.recetarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.recetario.recetarios.entities.Recers;
import com.recetario.recetarios.repository.RecersRepository;
import com.recetario.recetarios.repository.RecetarioRepository;

import org.springframework.stereotype.Component;

@Component
@Service("recersService")
public class RecersService {

    @Autowired
    @Qualifier("recersRepository") 
    private RecersRepository recersRepository;

    
    public Object addRecetaEnRecetario(int recetaId, int recetarioId) {
        return recersRepository.saveAndFlush(new Recers(recetaId, recetarioId));
	}

    public List<Recers> TraerRecetasPorRecetario(final int recetarioId) {
    return recersRepository.TraerRecetasPorRecetario(recetarioId);
  }
    
}

