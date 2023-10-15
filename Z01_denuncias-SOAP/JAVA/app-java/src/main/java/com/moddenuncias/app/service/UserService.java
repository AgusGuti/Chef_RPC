package com.moddenuncias.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.moddenuncias.app.entities.User;
import com.moddenuncias.app.repository.UserRepository;
import com.moddenuncias.model.UserProto;
import com.moddenuncias.model.UsersServiceGrpc;
import com.google.protobuf.Empty;

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
			usuarioRepository.save(new User(request.getNombre(),request.getApellido(),request.getEmail(),request.getClave(),request.getFotoPerfil()));
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
        .setFotoPerfil(request.getFotoPerfil())
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
        .setId(user.getId())
        .setNombre(user.getNombre())
        .setApellido(user.getApellido())
        .setEmail(user.getEmail())
        .setClave(user.getClave())
        .setFotoPerfil(user.getFotoPerfil())
        .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
        }
    }

    @Override
    public void traerUser(UserProto.User request,StreamObserver<UserProto.User> responseObserver) {

        User user =usuarioRepository.findById(request.getId());

        UserProto.User a = UserProto.User.newBuilder()
                    .setId(user.getId())
                    .build();

        responseObserver.onNext(a);
        responseObserver.onCompleted();
        
    }

   	@Override
	public void findAll(Empty request, StreamObserver<UserProto.Users> responseObserver) {
        List<UserProto.User> userdb = new ArrayList<>();

        for (User user : usuarioRepository.findAll()) {
            UserProto.User userProto = UserProto.User.newBuilder()
                    .setId(user.getId())
                    .setNombre(user.getNombre())
                    .setApellido(user.getApellido())
                    .setFotoPerfil(user.getFotoPerfil())
                    .build();
            userdb.add(userProto);
        }

        UserProto.Users a = UserProto.Users.newBuilder()
            .addAllUser(userdb)
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }

}

