package com.chefencasa.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.User;
import com.chefencasa.app.entities.Seguidos;
import com.chefencasa.app.repository.SeguidosRepository;
import com.chefencasa.app.repository.UserRepository;
import com.chefencasa.model.SeguidosProto.Seguido;
import com.chefencasa.model.SeguidoProto;
import com.chefencasa.model.SeguidosServiceGrpc;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class SeguidoService extends SeguidosServiceGrpc.SeguidosServiceImplBase { 
    AtomicInteger id = new AtomicInteger();

    @Autowired
	@Qualifier("seguidosRepository")
	private SeguidosRepository seguidosRepository;

    @Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

    @Override
    public void addSeguidos(SeguidoProto.Seguido request, StreamObserver<SeguidoProto.Seguido> responseObserver) {
       
        try {
			Seguidos seguido = new Seguidos(userRepository.findById(request.getUserId().getId()), userRepository.findById(request.getSeguidoId().getId()));

            seguidosRepository.save(seguido);
            
		} catch (Exception e) {
			try {
                throw new Exception("No se pudo completar la operación,error al ingresar los datos o el usuario ya existe");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}
        SeguidoProto.Seguido a = SeguidoProto.Seguido.newBuilder()
            .setId(request.getId())
            .setUserId(request.getUserId())
            .setSeguidoId(request.getSeguidoId())
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteSeguidos(SeguidoProto.Seguido request, StreamObserver<SeguidoProto.Seguido> responseObserver) {
       
        try {
			Seguidos seguido = new Seguidos(userRepository.findById(request.getUserId().getId()), userRepository.findById(request.getSeguidoId().getId()));

            seguidosRepository.delete(seguido);
            
		} catch (Exception e) {
			try {
                throw new Exception("No se pudo completar la operación,error al ingresar los datos o el usuario ya existe");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}
        SeguidoProto.Seguido a = SeguidoProto.Seguido.newBuilder()
            .setId(request.getId())
            .setUserId(request.getUserId())
            .setSeguidoId(request.getSeguidoId())
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }


    @Override
    public void deleteSeguidores(SeguidoProto.Seguido request, StreamObserver<SeguidoProto.Seguido> responseObserver) {
       
        try {
			Seguidos seguido = new Seguidos(userRepository.findById(request.getSeguidoId().getId()), userRepository.findById(request.getUserId().getId()));

            seguidosRepository.delete(seguido);
            
		} catch (Exception e) {
			try {
                throw new Exception("No se pudo completar la operación,error al ingresar los datos o el usuario ya existe");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}
        SeguidoProto.Seguido a = SeguidoProto.Seguido.newBuilder()
            .setId(request.getId())
            .setUserId(request.getSeguidoId())
            .setSeguidoId(request.getUserId())
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }
    

}

