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
        List<Ingrediente> ingredientes = ingredienteRepository.findAll(); // Obtener la lista de todos los ingredientes

        for (Ingrediente ingrediente : ingredientes) {
            IngredienteProto.Ingrediente ingredienteProto = IngredienteProto.Ingrediente.newBuilder()
                .setId(ingrediente.getId())
                .setNombre(ingrediente.getNombre())
                .build();
            
            responseObserver.onNext(ingredienteProto);
            }
    
        responseObserver.onCompleted();
    }

    @Override
	public void findAll(Empty request, StreamObserver<IngredienteProto.Ingredientes> responseObserver) {
        List<IngredienteProto.Ingrediente> ingredientedb = new ArrayList<>();
        for (Ingrediente ingrediente : ingredienteRepository.findAll()) {
            IngredienteProto.Ingrediente ingredienteProto = IngredienteProto.Ingrediente.newBuilder()
                    .setNombre(ingrediente.getNombre())
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
