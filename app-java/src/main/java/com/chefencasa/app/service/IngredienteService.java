package com.chefencasa.app.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.Ingrediente;
import com.chefencasa.app.repository.IngredienteRepository;
import com.chefencasa.model.IngredienteProto;
import com.chefencasa.model.IngredientesServiceGrpc;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class IngredienteService extends IngredientesServiceGrpc.IngredientesServiceImplBase {
    
    @Autowired
	@Qualifier("ingredienteRepository")
	private IngredienteRepository ingredienteRepository;

    @Override
    public void traerIngrediente(IngredienteProto.Ingrediente request, StreamObserver<IngredienteProto.Ingrediente> responseObserver) {
        Ingrediente ingrediente = ingredienteRepository.findById(request.getId()).get();
        IngredienteProto.Ingrediente a = IngredienteProto.Ingrediente.newBuilder()
                    .setIngrediente(ingrediente.getIngrediente())
                    .setId(ingrediente.getId())
                    .build();

        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }

    @Override
	public void findAll(Empty request, StreamObserver<IngredienteProto.Ingredientes> responseObserver) {
        List<IngredienteProto.Ingrediente> ingredientedb = new ArrayList<>();
        for (Ingrediente ingrediente : ingredienteRepository.findAll()) {
            IngredienteProto.Ingrediente ingredienteProto = IngredienteProto.Ingrediente.newBuilder()
                    .setIngrediente(ingrediente.getIngrediente())
                    .setId(ingrediente.getId())
                    .build();
            ingredientedb.add(ingredienteProto);
        }

        IngredienteProto.Ingredientes a = IngredienteProto.Ingredientes.newBuilder()
            .addAllIngrediente(ingredientedb)
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }
    
    
}
