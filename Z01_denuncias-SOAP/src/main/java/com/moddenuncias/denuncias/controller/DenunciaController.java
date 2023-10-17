package com.moddenuncias.denuncias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moddenuncias.denuncias.entities.Denuncia;
import com.moddenuncias.denuncias.service.DenunciaService;

public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    @PostMapping("/agregar")
    public Denuncia addDenuncia(@RequestParam("user_id") int user_id, @RequestParam("receta_id") int receta_id, @RequestParam("motivo_id") int motivo_id) {
        return (Denuncia) denunciaService.addDenuncia(user_id, receta_id, motivo_id);
    }

    @DeleteMapping("/resuelta/{denunciaId}")
    public void resolverDenuncia(@PathVariable int denunciaId) {
        denunciaService.resolverDenuncia(denunciaId);
    }

    @GetMapping("/denunciasAbiertas")
    public void verDenunciasAbiertas() {
        denunciaService.findUnresolved();
    }

    @GetMapping("/verMotivos")
    public void verMotivos() {
        denunciaService.verMotivos();
    }

    
    
}
