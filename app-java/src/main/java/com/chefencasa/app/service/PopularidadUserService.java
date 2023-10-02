package com.chefencasa.app.service;


import com.chefencasa.model.PopularidadRecetaProto;
import com.chefencasa.model.PopularidadUserProto;
import com.chefencasa.model.PopularidadUsersServiceGrpc;
import com.chefencasa.model.RecetaProto;
import com.chefencasa.model.UserProto;

import io.grpc.stub.StreamObserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.PopularidadReceta;
import com.chefencasa.app.entities.PopularidadUser;
import com.chefencasa.app.entities.User;
import com.chefencasa.app.repository.PopularidadRecetaRepository;
import com.chefencasa.app.repository.PopularidadUserRepository;
import com.chefencasa.app.repository.UserRepository;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PopularidadUserService extends PopularidadUsersServiceGrpc.PopularidadUsersServiceImplBase {


	@Autowired
	@Qualifier("popularidadUserRepository")
	private PopularidadUserRepository popularidadUserRepository;


    @Autowired
	@Qualifier("userRepository")
	private UserRepository usuarioRepository;


    Logger logger = LoggerFactory.getLogger(FavoritoService.class);

    public void guardarPopularidadUser(PopularidadUserProto.PopularidadUser request, StreamObserver<PopularidadUserProto.PopularidadUser> responseObserver) {
        try {
            String nombreUsuario = request.getUser().getNombre();
    
            // Verificar si la PopularidadUser ya existe para este nombre de usuario
            boolean popularidadUserExistente = popularidadUserRepository.existsByNombreUsuario(nombreUsuario);
            
            logger.info("PopularidadExistente: "+popularidadUserExistente);

            if (popularidadUserExistente) {
                // Si la PopularidadUser ya existe, actualiza su puntaje y guárdala
                PopularidadUser popularidadUser = popularidadUserRepository.findByUser(usuarioRepository.findById(request.getUser().getId()));
                popularidadUser.setPuntaje(request.getPuntaje());
                popularidadUserRepository.save(popularidadUser);
    
                // Envía una respuesta con la información actualizada
                PopularidadUserProto.PopularidadUser popularidadUserModificada = PopularidadUserProto.PopularidadUser.newBuilder()
                    .setId(popularidadUser.getId())
                    .setPuntaje(request.getPuntaje())
                    .setUser(UserProto.User.newBuilder().setNombre(nombreUsuario).build())
                    .build();
                responseObserver.onNext(popularidadUserModificada);
            } else {
                // Si la PopularidadUser no existe, crea una nueva instancia y guárdala
                PopularidadUser nuevaPopularidadUser = new PopularidadUser(request.getNombreUsuario(),request.getPuntaje()); // No asociar con un objeto User
                popularidadUserRepository.save(nuevaPopularidadUser);
    
                // Envía una respuesta con la información creada
                PopularidadUserProto.PopularidadUser a = PopularidadUserProto.PopularidadUser.newBuilder()
                    .setId(nuevaPopularidadUser.getId())
                    .setPuntaje(request.getPuntaje())
                    .setUser(UserProto.User.newBuilder().setNombre(nombreUsuario).build())
                    .build();
                responseObserver.onNext(a);
            }
    
            responseObserver.onCompleted();
        } catch (Exception e) {
            logger.error("Error al agregar Popularidad User", e);
        }
    }
    
    

    // @Override
    // public void traerComentario(PopularidadUserProto.Comentario request,StreamObserver<PopularidadUserProto.Comentario> responseObserver) {

    //     Comentario comentario = PopularidadRecetaRepository.findById(request.getId()).get();

    //     PopularidadUserProto.Comentario a = PopularidadUserProto.PopularidadReceta.newBuilder()
    //                 .setId(popularidadUser.getId())
    //                 .build();

    //     responseObserver.onNext(a);
    //     responseObserver.onCompleted();
        
    // }

   	// @Override
	// public void findAll(Empty request, StreamObserver<PopularidadUserProto.PopularidadUsers> responseObserver) {
    //     List<PopularidadUsersProto.PopularidadUsers> popularidadUserdb = new ArrayList<>();
    //     for (PopularidadUser id : popularidadUserRepository.findAll()) {
    //         PopularidadUserProto.PopularidadUser popularidadUserProto = PopularidadUserProto.Comentario.newBuilder()
    //                 .setId(popularidadUser.getId())
    //                 .build();
    //         popularidadUserdb.add(popularidadUserProto);
    //     }

    //     PopularidadUserProto.PopularidadUser a = PopularidadUserProto.PopularidadUser.newBuilder()
    //         .addAllPopularidadReceta(popularidadUserdb)
    //         .build();
    //     responseObserver.onNext(a);
    //     responseObserver.onCompleted();
    // }
}