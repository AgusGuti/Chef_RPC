package com.chefencasa.app.service;


import com.chefencasa.model.PopularidadUserProto;
import com.chefencasa.model.PopularidadUserProto;
import com.chefencasa.model.PopularidadUsersServiceGrpc;
import com.chefencasa.model.UserProto;
import com.chefencasa.model.UserProto;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.PopularidadUser;
import com.chefencasa.app.entities.PopularidadUser;
import com.chefencasa.app.entities.User;
import com.chefencasa.app.repository.PopularidadUserRepository;
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
    
            logger.info("PopularidadExistente: " + popularidadUserExistente);
    
            if (popularidadUserExistente) {
                // Si la PopularidadUser ya existe, actualiza su puntaje y guárdala
                PopularidadUser popularidadUser = popularidadUserRepository.findByNombreUsuario(nombreUsuario);
                popularidadUser.setPuntaje(request.getPuntaje());
                popularidadUserRepository.save(popularidadUser);
    
                // Envía una respuesta con la información actualizada
                PopularidadUserProto.PopularidadUser popularidadUserModificada = PopularidadUserProto.PopularidadUser.newBuilder()
                    .setId(popularidadUser.getId())
                    .setPuntaje(request.getPuntaje())
                    .setUser(request.getUser())  // Usa el objeto User de la request
                    .build();
                responseObserver.onNext(popularidadUserModificada);
            } else {
                // Si la PopularidadUser no existe, crea una nueva instancia y guárdala
                User user = usuarioRepository.findByNombre(nombreUsuario);
                PopularidadUser nuevaPopularidadUser = new PopularidadUser(user, nombreUsuario, request.getPuntaje());
                popularidadUserRepository.save(nuevaPopularidadUser);
    
                // Envía una respuesta con la información creada
                PopularidadUserProto.PopularidadUser a = PopularidadUserProto.PopularidadUser.newBuilder()
                    .setId(nuevaPopularidadUser.getId())
                    .setPuntaje(request.getPuntaje())
                    .setUser(request.getUser())  // Usa el objeto User de la request
                    .build();
                responseObserver.onNext(a);
            }   
    
            responseObserver.onCompleted();
        } catch (Exception e) {
            logger.error("Error al agregar Popularidad User", e);
        }
    }
    
    @Override
	public void findAll(Empty request, StreamObserver<PopularidadUserProto.PopularidadUsers> responseObserver) {
        List<PopularidadUserProto.PopularidadUser> popularidadUserdb = new ArrayList<>();
        
        for (PopularidadUser popularidadUser : popularidadUserRepository.findAll()) {
            PopularidadUserProto.PopularidadUser popularidadUserProto = PopularidadUserProto.PopularidadUser.newBuilder()
                .setPuntaje(popularidadUser.getPuntaje())
                .setUser(UserProto.User.newBuilder()
                    .setNombre(popularidadUser.getUser().getNombre())
                    .build())
                .build();
                    
            popularidadUserdb.add(popularidadUserProto);
        }

        PopularidadUserProto.PopularidadUsers a = PopularidadUserProto.PopularidadUsers.newBuilder()
            .addAllPopularidadUser(popularidadUserdb)
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }
    
}