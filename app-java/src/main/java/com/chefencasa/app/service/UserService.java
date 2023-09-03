package com.chefencasa.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.User;
import com.chefencasa.app.repository.UserRepository;
import com.chefencasa.model.UserProto;
import com.chefencasa.model.UsersServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserService extends UsersServiceGrpc.UsersServiceImplBase { 


	@Autowired
	@Qualifier("userRepository")
	private UserRepository usuarioRepository;

    @Override
    public void addUser(UserProto.User request, StreamObserver<UserProto.User> responseObserver) {
       
        try {
			usuarioRepository.save(new User(request.getId(),request.getEmail(),request.getName(),request.getNick(),request.getPassword(),request.getRole(),request.getSurname()));
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
        .setEmail(request.getEmail())
        .setName(request.getName())
        .setNick(request.getNick())
        .setPassword(request.getPassword())
        .setRole(request.getRole())
        .setSurname(request.getSurname())
        .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }
}
