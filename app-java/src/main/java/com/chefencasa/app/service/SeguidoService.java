package com.chefencasa.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.User;
import com.chefencasa.app.entities.Favorito;
import com.chefencasa.app.entities.Seguidos;
import com.chefencasa.app.repository.SeguidosRepository;
import com.chefencasa.app.repository.UserRepository;
import com.chefencasa.model.SeguidosProto.Seguido;
import com.chefencasa.model.SeguidoProto;
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
			Seguidos seguido = new Seguidos(userRepository.findById(request.getUser().getId()), userRepository.findById(request.getSeguido().getId()));

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
            .setUser(request.getUser())
            .setSeguido(request.getSeguido())
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteSeguidos(SeguidoProto.Seguido request, StreamObserver<SeguidoProto.Seguido> responseObserver) {
       
        try {
			Seguidos seguido = new Seguidos(userRepository.findById(request.getUser().getId()), userRepository.findById(request.getSeguido().getId()));

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
            .setUser(request.getUser())
            .setSeguido(request.getSeguido())
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }


    @Override
    public void deleteSeguidores(SeguidoProto.Seguido request, StreamObserver<SeguidoProto.Seguido> responseObserver) {
       
        try {
			Seguidos seguido = new Seguidos(userRepository.findById(request.getSeguido().getId()), userRepository.findById(request.getUser().getId()));

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
            .setUser(request.getSeguido())
            .setSeguido(request.getUser())
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }


    @Override
    public void checkSeguidos(SeguidoProto.Seguido request, StreamObserver<SeguidoProto.FlagSeguido> responseObserver) {
       
        Boolean existe = false;
               
        try {
			
            Seguidos seguido = seguidosRepository.checkSeguidos(request.getUser().getId(), request.getSeguido().getId());

            if(seguido != null){
                existe = true;
            }
            
		} catch (Exception e) {
			try {
                throw new Exception("No se pudo completar la operación,error al leer Seguidos");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}

        SeguidoProto.FlagSeguido a = SeguidoProto.FlagSeguido.newBuilder()
            .setFlagExiste(existe)
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }
    

}

