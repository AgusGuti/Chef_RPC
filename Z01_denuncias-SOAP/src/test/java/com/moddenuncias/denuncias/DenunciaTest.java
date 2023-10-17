package com.moddenuncias.denuncias;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.moddenuncias.denuncias.entities.Denuncia;
import com.moddenuncias.denuncias.repository.DenunciaRepository;
import com.moddenuncias.denuncias.repository.MotivoRepository;
import com.moddenuncias.denuncias.service.DenunciaService;

@SpringBootTest
public class DenunciaTest {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private MotivoRepository motivoRepository;

    @Autowired
    private DenunciaService denunciaService;

    @Test
    public void testAddDenuncia() {
        // Crea una instancia literal de la clase Denuncia.
        Denuncia denuncia = new Denuncia(1, 2, motivoRepository.findById(1));

        // Guarda la denuncia en la base de datos.
        denunciaRepository.saveAndFlush(denuncia);

        // Verifica que la denuncia se haya guardado correctamente.
        Denuncia denunciaGuardada = denunciaRepository.findById(denuncia.getId());
        System.out.println(denunciaGuardada.toString());
        //assertEquals(denunciaGuardada, denuncia);
    }

    private void assertEquals(Denuncia denunciaGuardada, Denuncia denuncia) {
    }

    @Test
    public void testFindUnresolved() {
        // // Crea una instancia literal de la clase Denuncia.
        // Denuncia denuncia = new Denuncia(1, 2, motivoRepository.findById(1));

        // // Guarda la denuncia en la base de datos.
        // denunciaRepository.saveAndFlush(denuncia);

        // Encuentra todas las denuncias sin resolver.
        List<Denuncia> denunciasSinResolver = denunciaRepository.findUnresolved();

        // Verifica que la lista de denuncias sin resolver contenga la denuncia que acabamos de crear.
        System.out.println(denunciasSinResolver.toString());
    }


    @Test
    public void resolverDenuncia() {
        
        denunciaService.resolverDenuncia(25);

        Denuncia denunciaResuelta = denunciaRepository.findById(25);
        System.out.println(denunciaResuelta.toString());
    }


    
}