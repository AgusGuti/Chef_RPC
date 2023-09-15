package com.chefencasa.app.service;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.Receta;
import com.chefencasa.app.entities.User;
import com.chefencasa.app.entities.Categoria;
import com.chefencasa.app.entities.Ingrediente;
import com.chefencasa.app.repository.CategoriaRepository;
import com.chefencasa.app.repository.IngredienteRepository;
import com.chefencasa.app.repository.RecetaRepository;
import com.chefencasa.app.repository.UserRepository;
import com.chefencasa.model.CategoriaProto;
import com.chefencasa.model.IngredienteProto;
import com.chefencasa.model.RecetaProto;
import com.chefencasa.model.RecetasServiceGrpc;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class RecetaService extends RecetasServiceGrpc.RecetasServiceImplBase {

	@Autowired
	@Qualifier("recetaRepository")
	private RecetaRepository recetaRepository;

	@Autowired
	@Qualifier("categoriaRepository")
	private CategoriaRepository categoriaRepository;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	@Qualifier("ingredienteRepository")
	private IngredienteRepository ingredienteRepository;

	Logger logger = LoggerFactory.getLogger(RecetaService.class);

    @Transactional
	public void addReceta(RecetaProto.Receta request, StreamObserver<RecetaProto.Receta> responseObserver) {
		 
		try {

			Receta receta = new Receta(userRepository.findById(request.getUser().getId()),
            categoriaRepository.findById(request.getCategoria().getId()).get(),
            request.getTituloReceta(),
            request.getDescripcion(),
            request.getPasos(),
            request.getTiempoPreparacion(),
            request.getFoto1(),
            request.getFoto2(),
            request.getFoto3(),
            request.getFoto4(),
            request.getFoto5()
			);
			for (IngredienteProto.Ingrediente ingrediente :request.getIngredientesList())
				receta.getIngredientes().add(ingredienteRepository.findById(ingrediente.getId()));

			recetaRepository.saveAndFlush(receta);

		} catch (Exception e) {
			System.err.println("Error al agregar la receta: " + e.getMessage());

			try {
                throw new Exception("No se pudo completar la operación,error al ingresar los datos o el usuario ya existe");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}

		RecetaProto.Receta r= RecetaProto.Receta.newBuilder()
		.setCategoria(CategoriaProto.Categoria.newBuilder().setCategoria(request.getCategoria().getCategoria()).build())
		.setTituloReceta(request.getTituloReceta())
		.setDescripcion(request.getDescripcion())
		.setPasos(request.getPasos())
		.setTiempoPreparacion(request.getTiempoPreparacion())
		.setFoto1(request.getFoto1())
		.setFoto2(request.getFoto2())
		.setFoto3(request.getFoto3())
		.setFoto4(request.getFoto4())
		.setFoto5(request.getFoto5())
		.build();
		responseObserver.onNext(r);
		responseObserver.onCompleted();
	}

	public void findAll(Empty request, StreamObserver<RecetaProto.Recetas> responseObserver) {
		List<RecetaProto.Receta> recetadb = new ArrayList<>();
		for (Receta receta : recetaRepository.findAllRecetasIngredientes()) {
			List<IngredienteProto.Ingrediente> lstIngredientes = new ArrayList<>();
			
			if (receta.getIngredientes() != null) {
				lstIngredientes.addAll(receta.getIngredientes().stream()
					.map(ingrediente -> IngredienteProto.Ingrediente.newBuilder()
						.setId(ingrediente.getId())
						.setNombre(ingrediente.getNombre())
						.build())
					.collect(Collectors.toList()));
			}
			
			RecetaProto.Receta recetaProto = RecetaProto.Receta.newBuilder()
				.setCategoria(CategoriaProto.Categoria.newBuilder()
					.setCategoria(receta.getCategoria().getCategoria())
					.build())
				.setDescripcion(receta.getDescripcion())
				.setIdReceta(receta.getId())
				.setTituloReceta(receta.getTituloReceta())
				.setPasos(receta.getPasos())
				.setTiempoPreparacion(receta.getTiempoPreparacion())
				.setFoto1(receta.getFoto1())
				.setFoto2(receta.getFoto2())
				.setFoto3(receta.getFoto3())
				.setFoto4(receta.getFoto4())
				.setFoto5(receta.getFoto5())
				.addAllIngredientes(lstIngredientes) // Agrega los ingredientes a la receta
				.build();
			
			recetadb.add(recetaProto);
		}
	
		RecetaProto.Recetas a = RecetaProto.Recetas.newBuilder()
			.addAllReceta(recetadb)
			.build();
		
		responseObserver.onNext(a);
		responseObserver.onCompleted();
	}

}