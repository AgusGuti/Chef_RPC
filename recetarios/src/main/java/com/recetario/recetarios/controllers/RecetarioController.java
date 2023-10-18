package com.recetario.recetarios.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.recetario.recetarios.entities.Recetario;
import com.recetario.recetarios.service.RecetarioService;

@RestController
@RequestMapping("/recetarios")
public class RecetarioController {
    @Autowired
    private RecetarioService recetarioService;

    @PostMapping("/agregar")
    public Recetario agregarRecetario(@RequestParam("nombre") String nombre) {
        return (Recetario) recetarioService.addRecetario(nombre);
    }

    @DeleteMapping("/eliminar/{recetarioId}")
    public void eliminarRecetario(@PathVariable int recetarioId) {
        recetarioService.deleteRecetario(recetarioId);
    }
}
