package com.recetario.recetarios.controllers;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.recetario.recetarios.entities.Recetario;
import com.recetario.recetarios.service.RecetarioService;

import com.recetario.recetarios.service.RecersService;

@RestController
@RequestMapping("/recetariossss")
public class RecetarioController {
    @Autowired
    private RecetarioService recetarioService;

    @Autowired
    private RecersService recersService;


    @PostMapping("/agregar")
    public Recetario agregarRecetario(@RequestParam("nombre") String nombre, @RequestParam("usarioId") int usarioId) {
        return (Recetario) recetarioService.addRecetario(nombre, usarioId);
    }

    @DeleteMapping("/eliminar/{recetarioId}")
    public void eliminarRecetario(@PathVariable int recetarioId) {
        recetarioService.deleteRecetario(recetarioId);
        recersService.eliminarRecetarios(recetarioId);
    }

    @GetMapping("/allRecetarios")
	public List<Recetario> TraerRecetarios(){
		return recetarioService.TraerRecetarios();
	}

    @GetMapping("/allRecetariosPorUsuario")
    public List<Recetario> TraerRecetariosPorUsuario(@RequestParam("usuarioId") int usuarioId) {
        return recetarioService.TraerRecetariosPorUsuario(usuarioId);
    }

}
