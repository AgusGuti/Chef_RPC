package com.chefencasa.app.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.Comentario;
import com.chefencasa.app.entities.PopularidadReceta;
import com.chefencasa.app.entities.Receta;
import com.chefencasa.app.repository.ComentarioRepository;
import com.chefencasa.app.repository.RecetaRepository;
import com.chefencasa.model.ComentarioProto;
import com.chefencasa.model.ComentariosServiceGrpc;
import com.chefencasa.model.RecetaProto;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ComentarioService extends ComentariosServiceGrpc.ComentariosServiceImplBase {


	@Autowired
	@Qualifier("comentarioRepository")
	private ComentarioRepository comentarioRepository;

    @Autowired
	@Qualifier("recetaRepository")
	private RecetaRepository recetaRepository;


    Logger logger = LoggerFactory.getLogger(ComentarioService.class);

    
    public void guardarComentario(ComentarioProto.Comentario request, StreamObserver<ComentarioProto.Comentario> responseObserver) {
        try {
            String recetaComentada = request.getRecetaComentada();
            String usuarioComentario = request.getUsuarioComentario();
    
            if (recetaComentada != null && usuarioComentario != null) {
                Receta receta = recetaRepository.findByTituloReceta(recetaComentada);
    
                if (receta != null) {
                    Comentario comentario = new Comentario(
                        usuarioComentario, 
                        recetaComentada,
                        request.getComentario(),
                        receta
                    );
    
                    comentarioRepository.save(comentario);
    
                    ComentarioProto.Comentario c = ComentarioProto.Comentario.newBuilder()
                        .setId(comentario.getId())
                        .setRecetaComentada(comentario.getRecetaComentada())
                        .setUsuarioComentario(comentario.getUsuarioComentario())
                        .setComentario(comentario.getComentario())
                        .setReceta(RecetaProto.Receta.newBuilder().setIdReceta(receta.getId()).build())
                        .build();
    
                    responseObserver.onNext(c);
                    responseObserver.onCompleted();
                } else {
                    logger.error("Error, no existe receta con el título: " + recetaComentada);
                }
            } else {
                logger.error("Error, no se proporcionó el título de la receta comentada o el usuario del comentario.");
            }
        } catch (Exception e) {
            logger.error("Error al agregar Comentario", e);
        }
    }

    public void findAllByReceta(ComentarioProto.Comentario request, StreamObserver<ComentarioProto.Comentarios> responseObserver) {
        
        int recetaId = request.getReceta().getIdReceta();
        
        List<Comentario> comentarios = comentarioRepository.findByRecetaRecetaId(recetaId);

        List<ComentarioProto.Comentario> comentarioProtos = new ArrayList<>();
        for (Comentario comentario : comentarios) {
            ComentarioProto.Comentario comentarioProto = ComentarioProto.Comentario.newBuilder()
                    .setId(comentario.getId())
                    .setRecetaComentada(comentario.getRecetaComentada())
                    .setUsuarioComentario(comentario.getUsuarioComentario())
                    .setComentario(comentario.getComentario())
                    .build();
            comentarioProtos.add(comentarioProto);
        }

        ComentarioProto.Comentarios comentariosResponse = ComentarioProto.Comentarios.newBuilder()
                .addAllComentario(comentarioProtos)
                .build();
        
        responseObserver.onNext(comentariosResponse);
        responseObserver.onCompleted();
    }
}