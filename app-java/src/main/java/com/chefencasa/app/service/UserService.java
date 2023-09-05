package com.chefencasa.app.service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.DigestUtils;

import com.chefencasa.app.entities.User;
import com.chefencasa.app.repository.UserRepository;
import com.chefencasa.model.UserProto;
import com.chefencasa.model.UsersServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserService extends UsersServiceGrpc.UsersServiceImplBase { 
    AtomicInteger id = new AtomicInteger();


	@Autowired
	@Qualifier("userRepository")
	private UserRepository usuarioRepository;

    @Override
    public void addUser(UserProto.User request, StreamObserver<UserProto.User> responseObserver) {
       
        try {
			usuarioRepository.save(new User(request.getNombre(),request.getApellido(),request.getEmail(),request.getClave(),request.getRol()));
		} catch (Exception e) {
			try {
                throw new Exception("No se pudo completar la operación,error al ingresar los datos o el usuario ya existe");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}
        UserProto.User a = UserProto.User.newBuilder()
        .setId(request.getId())
        .setNombre(request.getNombre())
        .setApellido(request.getApellido())
        .setEmail(request.getEmail())
        .setClave(request.getClave())
        .setRol(request.getRol())
        .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }
    
    @Override
    public void validarCredenciales(UserProto.User request, StreamObserver<UserProto.User> responseObserver) {

    User user= usuarioRepository.validarCredenciales(request.getNombre(),request.getEmail(),request.getClave());

    if (user==null) {
        UserProto.User a = UserProto.User.newBuilder()
        .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    } else {
        UserProto.User a = UserProto.User.newBuilder()
        .setId(request.getId())
        .setNombre(request.getNombre())
        .setApellido(request.getApellido())
        .setEmail(request.getEmail())
        .setClave(request.getClave())
        .setRol(request.getRol())
        .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
        }
    }
    
}
