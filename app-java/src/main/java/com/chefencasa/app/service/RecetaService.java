package com.chefencasa.app.service;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import com.chefencasa.app.entities.Receta;
import com.chefencasa.app.entities.Receta;
import com.chefencasa.app.entities.Ingrediente;
import com.chefencasa.app.repository.CategoriaRepository;
import com.chefencasa.app.repository.IngredienteRepository;
import com.chefencasa.app.repository.RecetaRepository;
import com.chefencasa.app.repository.UserRepository;
import com.chefencasa.model.CategoriaProto;
import com.chefencasa.model.IngredienteProto;
import com.chefencasa.model.RecetaProto;
import com.chefencasa.model.RecetasServiceGrpc;
import com.chefencasa.model.RecetaProto;
import com.chefencasa.model.UserProto;
import com.google.gson.Gson;
import com.google.protobuf.Empty;
import com.chefencasa.app.dto.ComentarioDTO;
import com.chefencasa.app.dto.NovedadesDTO;
import com.chefencasa.app.dto.PopularidadRecetaDTO;
import com.chefencasa.app.dto.PopularidadUsuarioDTO;

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

	// Inyecta el KafkaTemplate
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate; 


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

			recetaRepository.save(receta);

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

			// Creamos un objeto NovedadesDTO para enviar como JSON
			String mensaje = new Gson().toJson(new NovedadesDTO(
				userRepository.findById(request.getUser().getId()).getNombre(),
				request.getTituloReceta(),
				request.getFoto1()
			));

			kafkaTemplate.send("novedades",mensaje);
			
		} catch (Exception e) {
			System.err.println("Error al agregar la receta: " + e.getMessage());
		}
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
				.setUser(UserProto.User.newBuilder()
								.setId(receta.getUser().getId())
								.setNombre(receta.getUser().getNombre())
								.setApellido(receta.getUser().getApellido())
								.setEmail(receta.getUser().getEmail())
								.setFotoPerfil(receta.getUser().getFotoPerfil())
								.build())
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


	public void findById(RecetaProto.Receta request, StreamObserver<RecetaProto.Receta> responseObserver) {
    try {
        int recetaId = request.getIdReceta();
        Receta receta = recetaRepository.findById(recetaId);

        if (receta !=null) {

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
							.setId(receta.getCategoria().getId())
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
                    .addAllIngredientes(lstIngredientes)
                    .build();

            responseObserver.onNext(recetaProto);
            responseObserver.onCompleted();
        } 
    } catch (Exception e) {
        System.err.println("Error al buscar la receta por ID: " + e.getMessage());
    	}
	}

	@Transactional
	public void modificarReceta(RecetaProto.Receta request, StreamObserver<RecetaProto.Receta> responseObserver) {
		logger.info("RECETA::"+request.getIdReceta());
		Receta receta = recetaRepository.findById(request.getIdReceta());
	
				// Actualizar la categoría de la receta
				receta.setCategoria(categoriaRepository.findById(request.getCategoria().getId()).get());

				// Actualizar otros campos de la receta
				receta.setTituloReceta(request.getTituloReceta());
				receta.setDescripcion(request.getDescripcion());
				receta.setPasos(request.getPasos());
				receta.setTiempoPreparacion(request.getTiempoPreparacion());
				receta.setFoto1(request.getFoto1());
				receta.setFoto2(request.getFoto2());
				receta.setFoto3(request.getFoto3());
				receta.setFoto4(request.getFoto4());
				receta.setFoto5(request.getFoto5());

				// Crear un conjunto para los ingredientes actualizados
				Set<Ingrediente> ingredientesActualizados = new HashSet<>();

				// Actualizar los ingredientes de la receta
				for (IngredienteProto.Ingrediente ingredienteProto : request.getIngredientesList()) {	
					ingredientesActualizados.add(ingredienteRepository.findById(ingredienteProto.getId()));
					
				}
				
				receta.setIngredientes(ingredientesActualizados);

				recetaRepository.saveAndFlush(receta);

				
				// Crear una respuesta con la receta modificada
				RecetaProto.Receta recetaModificada = RecetaProto.Receta.newBuilder()
						.setIdReceta(receta.getId())
						.setCategoria(CategoriaProto.Categoria.newBuilder()
								.setId(receta.getCategoria().getId())
								.setCategoria(receta.getCategoria().getCategoria())
								.build())
						.setTituloReceta(receta.getTituloReceta())
						.setDescripcion(receta.getDescripcion())
						.setPasos(receta.getPasos())
						.setTiempoPreparacion(receta.getTiempoPreparacion())
						.setFoto1(receta.getFoto1())
						.setFoto2(receta.getFoto2())
						.setFoto3(receta.getFoto3())
						.setFoto4(receta.getFoto4())
						.setFoto5(receta.getFoto5())
						.addAllIngredientes(request.getIngredientesList()) // Usamos los mismos ingredientes que se enviaron en la solicitud
						.build();

			responseObserver.onNext(recetaModificada);
			responseObserver.onCompleted();

	}

	public void findAllById(RecetaProto.Receta request, StreamObserver<RecetaProto.Recetas> responseObserver) {
		try {
			
			int usuarioId = request.getUser().getId();
			logger.info("Usuario ID: " + usuarioId);
			
			List<Receta> recetas = recetaRepository.findAllRecetasByUserId(usuarioId);
			List<RecetaProto.Receta> recetadb = new ArrayList<>();
	
			for (Receta receta : recetas) {
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
						.addAllIngredientes(lstIngredientes)
						.build();
	
				recetadb.add(recetaProto);
			}
			
			RecetaProto.Recetas a = RecetaProto.Recetas.newBuilder()
					.addAllReceta(recetadb)
					.build();
		
			responseObserver.onNext(a);
			responseObserver.onCompleted();
	
		} catch (Exception e) {
			logger.info("Error al traer Mis Recetas", e);
		}
	}

	
	public void addComentario(RecetaProto.Receta request, StreamObserver<RecetaProto.Receta> responseObserver) {
		
		// Creamos un objeto ComentarioDTO para enviar como JSON
		String mensaje = new Gson().toJson(new ComentarioDTO(
			userRepository.findById(request.getUser().getId()).getNombre(),
			request.getTituloReceta(),
			request.getComentario()
		));

		kafkaTemplate.send("comentario",mensaje);
		
        Receta receta = recetaRepository.findById(request.getIdReceta());

		if (receta != null) {
			int propietarioRecetaId = receta.getUser().getId();

            // Verificamos si el usuario actual es el propietario de la receta
            int usuarioActualId = request.getUser().getId();
            boolean esDuenoDeReceta = usuarioActualId == propietarioRecetaId;

            if (!esDuenoDeReceta) {
                // Creamos un objeto PopularidadRecetaDTO para enviar como JSON
                String mensaje2 = new Gson().toJson(new PopularidadRecetaDTO(
                    request.getIdReceta(),
                    "+1"
                ));

                kafkaTemplate.send("popularidadReceta", mensaje2);
            }
        } else {
            logger.info("No se encontro la receta");
        }
		
		RecetaProto.Receta a = RecetaProto.Receta.newBuilder()
			.build();
		
		responseObserver.onNext(a);
		responseObserver.onCompleted();
	}


	public void addPuntaje(RecetaProto.Receta request, StreamObserver<RecetaProto.Receta> responseObserver) {
		
		// Creamos un objeto PopularidadRecetaDTO para enviar como JSON
		String mensaje = new Gson().toJson(new PopularidadRecetaDTO(
			request.getIdReceta(), request.getPuntaje()
		));

		kafkaTemplate.send("popularidadReceta",mensaje);

		RecetaProto.Receta a = RecetaProto.Receta.newBuilder()
			.build();
		
		responseObserver.onNext(a);
		responseObserver.onCompleted();
	}


	@Transactional
    public void deleteReceta(RecetaProto.Receta request, StreamObserver<RecetaProto.Receta> responseObserver) {
    
        try {
			Receta receta = recetaRepository.findById(request.getIdReceta());
            logger.info("Receta a eliminar"+ receta);
                        
            recetaRepository.delete(receta);
            
		} catch (Exception e) {
            logger.error("Error al eliminar Receta", e);
        }

        RecetaProto.Receta a = RecetaProto.Receta.newBuilder()
            .setIdReceta(request.getIdReceta())
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }
}