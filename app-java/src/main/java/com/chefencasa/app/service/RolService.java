package com.chefencasa.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.Rol;
import com.chefencasa.app.repository.RolRepository;
import com.chefencasa.model.RolProto;
import com.chefencasa.model.RolsServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class RolService extends RolsServiceGrpc.RolsServiceImplBase { 


	@Autowired
	@Qualifier("rolRepository")
	private RolRepository rolRepository;

    @Override
    public void addRol(RolProto.Rol request, StreamObserver<RolProto.Rol> responseObserver) {
       
        try {
			rolRepository.save(new Rol(request.getId(),request.getRol()));
		} catch (Exception e) {
			try {
                throw new Exception("No se pudo completar la operación, error al ingresar los datos o el Rol ya existe");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}
        RolProto.Rol a = RolProto.Rol.newBuilder()
        .setId(request.getId())
        .setRol(request.getRol())
        .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }
}
