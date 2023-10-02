package com.chefencasa.app.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.Comentario;
import com.chefencasa.app.repository.ComentarioRepository;
import com.chefencasa.model.ComentarioProto;
import com.chefencasa.model.ComentariosServiceGrpc;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ComentarioService extends ComentariosServiceGrpc.ComentariosServiceImplBase {


	// @Autowired
	// @Qualifier("comentarioRepository")
	// private ComentarioRepository categoriaRepository;

    // @Override
    // public void traerComentario(ComentarioProto.Comentario request,StreamObserver<ComentarioProto.Comentario> responseObserver) {

    //     Comentario comentario = ComentarioRepository.findById(request.getId()).get();

    //     ComentarioProto.Comentario a = ComentarioProto.Comentario.newBuilder()
    //                 .setId(comentario.getId())
    //                 .setComentario(comentario.getComentario())
    //                 .build();

    //     responseObserver.onNext(a);
    //     responseObserver.onCompleted();
        
    // }

   	// @Override
	// public void findAll(Empty request, StreamObserver<ComentarioProto.Comentarios> responseObserver) {
    //     List<ComentarioProto.Comentario> comentariodb = new ArrayList<>();
    //     for (Comentario comentario : comentarioRepository.findAll()) {
    //         ComentarioProto.Comentario comentarioProto = ComentarioProto.Comentario.newBuilder()
    //                 .setId(comentario.getId())
    //                 .setCategoria(comentario.getComentario())
    //                 .build();
    //         comentariodb.add(comentarioProto);
    //     }

    //     ComentarioProto.Comentarios a = ComentarioProto.Comentarios.newBuilder()
    //         .addAllComentario(comentariodb)
    //         .build();
    //     responseObserver.onNext(a);
    //     responseObserver.onCompleted();
    // }
}