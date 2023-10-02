package com.chefencasa.app.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.Comentario;
import com.chefencasa.app.entities.PopularidadReceta;
import com.chefencasa.app.repository.PopularidadRecetaRepository;
import com.chefencasa.model.PopularidadRecetaProto;
import com.chefencasa.model.PopularidadRecetasServiceGrpc;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PopularidadRecetaService extends PopularidadRecetasServiceGrpc.PopularidadRecetasServiceImplBase {


	// @Autowired
	// @Qualifier("popularidadRecetaRepository")
	// private PopularidadRecetaRepository popularidadRecetaRepository;

    // @Override
    // public void traerComentario(PopularidadRecetaProto.Comentario request,StreamObserver<PopularidadRecetaProto.Comentario> responseObserver) {

    //     Comentario comentario = PopularidadRecetaRepository.findById(request.getId()).get();

    //     PopularidadRecetaProto.Comentario a = PopularidadRecetaProto.PopularidadReceta.newBuilder()
    //                 .setId(popularidadReceta.getId())
    //                 .build();

    //     responseObserver.onNext(a);
    //     responseObserver.onCompleted();
        
    // }

   	// @Override
	// public void findAll(Empty request, StreamObserver<PopularidadRecetaProto.PopularidadRecetas> responseObserver) {
    //     List<PopularidadRecetasProto.PopularidadRecetas> popularidadRecetadb = new ArrayList<>();
    //     for (PopularidadReceta id : popularidadRecetaRepository.findAll()) {
    //         PopularidadRecetaProto.PopularidadReceta popularidadRecetaProto = PopularidadRecetaProto.Comentario.newBuilder()
    //                 .setId(popularidadReceta.getId())
    //                 .build();
    //         popularidadRecetadb.add(popularidadRecetaProto);
    //     }

    //     PopularidadRecetaProto.PopularidadReceta a = PopularidadRecetaProto.PopularidadReceta.newBuilder()
    //         .addAllPopularidadReceta(popularidadRecetadb)
    //         .build();
    //     responseObserver.onNext(a);
    //     responseObserver.onCompleted();
    // }
}