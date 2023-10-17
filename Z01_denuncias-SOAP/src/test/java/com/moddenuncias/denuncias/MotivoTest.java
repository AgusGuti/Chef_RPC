package com.moddenuncias.denuncias;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.moddenuncias.denuncias.entities.Motivo;
import com.moddenuncias.denuncias.repository.DenunciaRepository;
import com.moddenuncias.denuncias.repository.MotivoRepository;
import com.moddenuncias.denuncias.service.DenunciaService;

@SpringBootTest
public class MotivoTest {

    @Autowired
    private MotivoRepository motivoRepository;

    @Autowired
    private DenunciaService denunciaService;

    @Test
    public void testCargarMotivos() {
        // Carga los tres motivos predeterminados en la base de datos.
        // motivoRepository.saveAndFlush(new Motivo("Contenido inapropiado"));
        // motivoRepository.saveAndFlush(new Motivo("Ingredientes prohibidos"));
        // motivoRepository.saveAndFlush(new Motivo("Peligroso para la salud"));

        // Encuentra todos los motivos en la base de datos.
        List<Motivo> motivos = motivoRepository.findAll();

        System.out.println(motivos.toString());

        
    }

    @Test
    public void testVerMotivos() {
        // Carga los tres motivos predeterminados en la base de datos.
        // motivoRepository.saveAndFlush(new Motivo("Contenido inapropiado"));
        // motivoRepository.saveAndFlush(new Motivo("Ingredientes prohibidos"));
        // motivoRepository.saveAndFlush(new Motivo("Peligroso para la salud"));

        // Encuentra todos los motivos en la base de datos.
        List<Motivo> motivos = denunciaService.verMotivos();

        System.out.println(motivos.toString());
    }
}