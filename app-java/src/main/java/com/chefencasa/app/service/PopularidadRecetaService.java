package com.chefencasa.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.PopularidadReceta;
import com.chefencasa.app.repository.PopularidadRecetaRepository;
import com.chefencasa.app.repository.RecetaRepository;
import com.chefencasa.model.CategoriaProto;
import com.chefencasa.model.PopularidadRecetaProto;
import com.chefencasa.model.PopularidadRecetasServiceGrpc;
import com.chefencasa.model.RecetaProto;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PopularidadRecetaService extends PopularidadRecetasServiceGrpc.PopularidadRecetasServiceImplBase {


	@Autowired
	@Qualifier("popularidadRecetaRepository")
	private PopularidadRecetaRepository popularidadRecetaRepository;

    @Autowired
	@Qualifier("recetaRepository")
	private RecetaRepository recetaRepository;

    Logger logger = LoggerFactory.getLogger(FavoritoService.class);

    public void guardarPopularidadReceta(PopularidadRecetaProto.PopularidadReceta request, StreamObserver<PopularidadRecetaProto.PopularidadReceta> responseObserver) {
        
        try {
            boolean PopularidadRecetaExistente = popularidadRecetaRepository.existsByReceta(recetaRepository.findById(request.getReceta().getIdReceta()));
    
            if (PopularidadRecetaExistente) {
                // Si la PopularidadReceta ya existe, actualiza su puntaje y guárdala
                PopularidadReceta popularidadReceta = popularidadRecetaRepository.findByReceta(recetaRepository.findById(request.getReceta().getIdReceta()));
                popularidadReceta.setPuntaje(request.getPuntaje());
                popularidadRecetaRepository.save(popularidadReceta);
    
                // Envía una respuesta con la información actualizada
                PopularidadRecetaProto.PopularidadReceta popularidadRecetaModificada = PopularidadRecetaProto.PopularidadReceta.newBuilder()
                    .setId(popularidadReceta.getId())
                    .setPuntaje(popularidadReceta.getPuntaje())
                    .setReceta(RecetaProto.Receta.newBuilder().setIdReceta(popularidadReceta.getReceta().getId()).build())
                    .build();
                responseObserver.onNext(popularidadRecetaModificada);
            } else {
                // Si la PopularidadReceta no existe, crea una nueva instancia y guárdala
                popularidadRecetaRepository.save(new PopularidadReceta(recetaRepository.findById(request.getReceta().getIdReceta()), request.getPuntaje()));
    
                // Envía una respuesta con la información creada
                PopularidadRecetaProto.PopularidadReceta a = PopularidadRecetaProto.PopularidadReceta.newBuilder()
                    .setId(request.getId())
                    .setPuntaje(request.getPuntaje())
                    .setReceta(RecetaProto.Receta.newBuilder().setIdReceta(request.getReceta().getIdReceta()).build())
                    .build();
                responseObserver.onNext(a);
            }
    
            responseObserver.onCompleted();
        } catch (Exception e) {
            logger.error("Error al agregar Popularidad Receta", e);
        }
    }


   	@Override
	public void findAll(Empty request, StreamObserver<PopularidadRecetaProto.PopularidadRecetas> responseObserver) {
        List<PopularidadRecetaProto.PopularidadReceta> popularidadRecetadb = new ArrayList<>();
        
        for (PopularidadReceta popularidadReceta : popularidadRecetaRepository.findAll()) {
            PopularidadRecetaProto.PopularidadReceta popularidadRecetaProto = PopularidadRecetaProto.PopularidadReceta.newBuilder()
                .setPuntaje(popularidadReceta.getPuntaje())
                .setReceta(RecetaProto.Receta.newBuilder()
                    .setTituloReceta(popularidadReceta.getReceta().getTituloReceta())
                    .build())
                    
                .build();
                    
            popularidadRecetadb.add(popularidadRecetaProto);
        }

        PopularidadRecetaProto.PopularidadRecetas a = PopularidadRecetaProto.PopularidadRecetas.newBuilder()
            .addAllPopularidadReceta(popularidadRecetadb)
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }
}