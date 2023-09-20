package com.chefencasa.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.User;
import com.chefencasa.app.entities.Favorito;
import com.chefencasa.app.repository.FavoritoRepository;
import com.chefencasa.app.repository.RecetaRepository;
import com.chefencasa.app.repository.UserRepository;
import com.chefencasa.model.FavoritoProto;
import com.chefencasa.model.FavoritosServiceGrpc;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class FavoritoService extends FavoritosServiceGrpc.FavoritosServiceImplBase { 
    AtomicInteger id = new AtomicInteger();

    @Autowired
	@Qualifier("favoritoRepository")
	private FavoritoRepository favoritoRepository;

    @Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

    @Autowired
	@Qualifier("recetaRepository")
	private RecetaRepository recetaRepository;

    @Override
    public void addFavoritos(FavoritoProto.Favorito request, StreamObserver<FavoritoProto.Favorito> responseObserver) {
       
        try {
			Favorito favorito = new Favorito(userRepository.findById(request.getUserId().getId()), recetaRepository.findById(request.getRecetaId().getIdReceta()));

            favoritoRepository.save(favorito);
            
		} catch (Exception e) {
			try {
                throw new Exception("No se pudo completar la operación,error al ingresar los datos o el usuario ya existe");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}
        FavoritoProto.Favorito a = FavoritoProto.Favorito.newBuilder()
            .setId(request.getId())
            .setUserId(request.getUserId())
            .setRecetaId(request.getRecetaId())
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteFavoritos(FavoritoProto.Favorito request, StreamObserver<FavoritoProto.Favorito> responseObserver) {
       
        try {
			Favorito favorito = new Favorito(userRepository.findById(request.getUserId().getId()), recetaRepository.findById(request.getRecetaId().getIdReceta()));

            favoritoRepository.delete(favorito);
            
		} catch (Exception e) {
			try {
                throw new Exception("No se pudo completar la operación,error al ingresar los datos o el usuario ya existe");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}
        FavoritoProto.Favorito a = FavoritoProto.Favorito.newBuilder()
            .setId(request.getId())
            .setUserId(request.getUserId())
            .setRecetaId(request.getRecetaId())
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }
    

}

