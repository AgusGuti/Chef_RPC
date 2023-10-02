package com.chefencasa.app.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.Comentario;
import com.chefencasa.app.entities.PopularidadReceta;
import com.chefencasa.app.repository.PopularidadRecetaRepository;
import com.chefencasa.model.PopularidadUserProto;
import com.chefencasa.model.PopularidadUsersServiceGrpc;
import com.chefencasa.model.PopularidadRecetasServiceGrpc;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PopularidadUserService extends PopularidadUsersServiceGrpc.PopularidadUsersServiceImplBase {


	// @Autowired
	// @Qualifier("popularidadUserRepository")
	// private PopularidadRecetaRepository popularidadUserRepository;

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