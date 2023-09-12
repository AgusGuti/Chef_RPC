package com.chefencasa.app.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.Categoria;
import com.chefencasa.app.repository.CategoriaRepository;
import com.chefencasa.model.CategoriaProto;
import com.chefencasa.model.CategoriasServiceGrpc;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CategoriaService extends CategoriasServiceGrpc.CategoriasServiceImplBase {


	@Autowired
	@Qualifier("categoriaRepository")
	private CategoriaRepository categoriaRepository;

    @Override
    public void traerCategoria(CategoriaProto.Categoria request,StreamObserver<CategoriaProto.Categoria> responseObserver) {

        Categoria categoria =categoriaRepository.findById(request.getId()).get();

        CategoriaProto.Categoria a = CategoriaProto.Categoria.newBuilder()
                    .setCategoria(categoria.getCategoria())
                    .setId(categoria.getId())
                    .build();

        responseObserver.onNext(a);
        responseObserver.onCompleted();
        
    }

   	@Override
	public void findAll(Empty request, StreamObserver<CategoriaProto.Categorias> responseObserver) {
        List<CategoriaProto.Categoria> categoriadb = new ArrayList<>();
        for (Categoria categoria : categoriaRepository.findAll()) {
            CategoriaProto.Categoria categoriaProto = CategoriaProto.Categoria.newBuilder()
                    .setCategoria(categoria.getCategoria())
                    .setId(categoria.getId())
                    .build();
            categoriadb.add(categoriaProto);
        }

        CategoriaProto.Categorias a = CategoriaProto.Categorias.newBuilder()
            .addAllCategoria(categoriadb)
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }
}