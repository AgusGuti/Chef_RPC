package com.recetario.recetarios.controllers;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.recetario.recetarios.entities.Recers;
import com.recetario.recetarios.service.RecersService;
import com.recetario.recetarios.service.RecetarioService;

@RestController
@RequestMapping("/recers")
public class RecersController {
    @Autowired
    private RecersService recersService;

    @PostMapping("/agregarRecetasEnRecetario")
    public Recers agregarReceta(@RequestParam("recetaId") int recetaId, @RequestParam("recetarioId") int recetarioId) {
        return (Recers) recersService.addRecetaEnRecetario(recetaId, recetarioId);
    }

    @GetMapping("/allRecetasPorRecetario")
    public List<Recers> TraerRecetasPorRecetario(@RequestParam("recetarioId") int recetarioId) {
        return recersService.TraerRecetasPorRecetario(recetarioId);
    }
}
