package com.moddenuncias.denuncias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import com.moddenuncias.denuncias.entities.Denuncia;
import com.moddenuncias.denuncias.entities.Motivo;
import com.moddenuncias.denuncias.repository.DenunciaRepository;
import com.moddenuncias.denuncias.repository.MotivoRepository;


@Component
@Service("denunciaService")
public class DenunciaService {

    @Autowired
	@Qualifier("denunciaRepository")
	private DenunciaRepository denunciaRepository;

    @Autowired
	@Qualifier("motivoRepository")
	private MotivoRepository motivoRepository;


    public Denuncia addDenuncia(int user_id, int receta_id, int motivo_id){
       return denunciaRepository.saveAndFlush(new Denuncia(user_id, receta_id, motivoRepository.findById(motivo_id)));
    }

    public List<Denuncia> findUnresolved(){
        return denunciaRepository.findUnresolved();
    }

    public void cargarMotivos(){
        
        motivoRepository.saveAndFlush(new Motivo("Contenido inapropiado"));
        motivoRepository.saveAndFlush(new Motivo("Ingredientes prohibidos"));
        motivoRepository.saveAndFlush(new Motivo("Peligroso para la salud"));

    }

    public void resolverDenuncia(int denunciaId){

        Denuncia modificada = denunciaRepository.findById(denunciaId);

        modificada.setResuelta("1");

        denunciaRepository.saveAndFlush(modificada);
    };

    public void resolverDenunciaPorBajaReceta(int receta_id){

        List<Denuncia> modificadas = denunciaRepository.findByRecetaId(receta_id);

        for (Denuncia modificada : modificadas) {
            modificada.setResuelta("1");

            denunciaRepository.saveAndFlush(modificada);
        }
        
    };


    public List<Motivo> verMotivos(){

        return motivoRepository.findAll();

    };

    

    
}
