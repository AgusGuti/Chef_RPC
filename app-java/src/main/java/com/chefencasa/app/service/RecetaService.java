package com.chefencasa.app.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.chefencasa.app.repository.CategoriaRepository;
import com.chefencasa.app.repository.IngredienteRepository;
import com.chefencasa.app.repository.RecetaRepository;
import com.chefencasa.app.repository.UserRepository;
import com.chefencasa.model.RecetaProto;
import com.chefencasa.model.RecetaProto.Empty;
import com.chefencasa.model.RecetaProto.Receta;
import com.chefencasa.model.RecetaProto.RecetaFiltro;
import com.chefencasa.model.RecetaProto.RecetaResponse;
import com.chefencasa.model.RecetaProto.RecetasResponse;
import com.chefencasa.model.RecetaProto.UpdateRecetaRequest;
import com.chefencasa.model.RecetaProto.UsuarioId;
import com.chefencasa.model.RecetasServiceGrpc;
import com.google.protobuf.Timestamp;

import io.grpc.stub.StreamObserver;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class RecetaService extends RecetasServiceGrpc.RecetasServiceImplBase {

	@Autowired
	@Qualifier("recetaRepository")
	private RecetaRepository recetaRepository;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	@Qualifier("categoriaRepository")
	private CategoriaRepository categoriaRepository;

	@Autowired
	@Qualifier("ingredienteRepository")
	private IngredienteRepository ingredienteRepository;

	@Override
	@Transactional
	public void addReceta(Receta request, StreamObserver<RecetaResponse> responseObserver) {
		RecetaResponse.Builder response = RecetaResponse.newBuilder();
		try {
			Receta receta = request;
			com.chefencasa.app.entities.Receta recetita = new com.chefencasa.app.entities.Receta(
					userRepository.findById(receta.getIdUsuario()),
					categoriaRepository.findByCategoria(receta.getCategoria()), receta.getTituloReceta(),
					receta.getDescripcion(), receta.getPasos(), receta.getTiempoPreparacion(), LocalDateTime.now(),
					receta.getFoto1(), receta.getFoto2(), receta.getFoto3(), receta.getFoto4(), receta.getFoto5());
			recetita.setIngredientes(new HashSet<>());
			recetita.setIngredientes(ingresarIngredientesYObtenerLista(receta.getIngredientesList(), recetita));
			recetaRepository.save(recetita);
			response.setReceta(receta);
			response.setMensaje("Receta agregada exitosamente");
		} catch (Exception e) {
			response.setMensaje("Ha ocurrido un error al ingresar la receta");
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();

	}

	@Override
	public void getByFilter(RecetaFiltro request, StreamObserver<RecetasResponse> responseObserver) {
		RecetasResponse.Builder response = RecetasResponse.newBuilder();
		try {
			Specification<com.chefencasa.app.entities.Receta> specification = (root, query, criteriaBuilder) -> {
	            List<Predicate> predicates = new ArrayList<>();

	            if (!request.getCategoria().isEmpty()) {
	            	Join<com.chefencasa.app.entities.Receta, com.chefencasa.app.entities.Categoria> categoriaJoin = root.join("categoria");
	                predicates.add(criteriaBuilder.equal(categoriaJoin.get("categoria"), request.getCategoria()));
	            }
	            if (!request.getNombre().isEmpty()) {
	                predicates.add(criteriaBuilder.like(root.get("nombre"), "%" + request.getNombre() + "%"));
	            }
	            if (request.getTiempoPrepDesde()!=0 && request.getTiempoPrepHasta()!=0) {
	                predicates.add(criteriaBuilder.between(
	                    root.get("tiempoPreparacion"),
	                    request.getTiempoPrepDesde(),
	                    request.getTiempoPrepHasta()
	                ));
	            } else if (request.getTiempoPrepDesde()!=0) {
	                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
	                    root.get("tiempoPreparacion"),
	                    request.getTiempoPrepDesde()
	                ));
	            } else if (request.getTiempoPrepHasta()!=0) {
	                predicates.add(criteriaBuilder.lessThanOrEqualTo(
	                    root.get("tiempoPreparacion"),
	                    request.getTiempoPrepHasta()
	                ));
	            }
	            if (request.getIngredientesCount() > 0) {
	                Set<String> ingredientes = new HashSet<>(request.getIngredientesList());
	                Join<com.chefencasa.app.entities.Receta, com.chefencasa.app.entities.Ingrediente> ingredientesJoin = root.joinSet("ingredientes");
	                predicates.add(ingredientesJoin.get("nombre").in(ingredientes));
	            }
	            query.orderBy(criteriaBuilder.desc(root.get("fechaCreacion")));
	            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	        };
	        List<com.chefencasa.app.entities.Receta> result = recetaRepository.findAll(specification);
	        if (result.isEmpty()) {
	        	response.setMensaje("No hay recetas con esos criterios");
	        } else {
	        	for (com.chefencasa.app.entities.Receta receta : result) {
		        	response.addReceta(convertirRecetaARecetaProto(receta));
		        }
	        	response.setMensaje("Recetas obtenidas satisfactoriamente");
	        }

		} catch (Exception e) {
			response.setMensaje("Ha ocurrido un error al obtener las recetas.");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void getAllRecetas(Empty request, StreamObserver<RecetasResponse> responseObserver) {
		RecetasResponse.Builder response = RecetasResponse.newBuilder();
		try {
			List<com.chefencasa.app.entities.Receta> recetas = recetaRepository.findAll();
			for (com.chefencasa.app.entities.Receta receta : recetas) {
				RecetaProto.Receta recetaProto = convertirRecetaARecetaProto(receta);
				response.addReceta(recetaProto);
			}
			if (recetas.isEmpty()) {
				response.setMensaje("No se encontraron recetas.");
			}
			response.setMensaje("Recetas obtenidas exitosamente");
		} catch (Exception e) {
			response.setMensaje("Ha ocurrido un error al obtener las recetas.");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void getAllRecetasByUser(UsuarioId request, StreamObserver<RecetasResponse> responseObserver) {
		RecetasResponse.Builder response = RecetasResponse.newBuilder();
		try {
			int userId = request.getIdUsuario();
			List<com.chefencasa.app.entities.Receta> recetasDelUsuario = recetaRepository.findByUserId(userId);
			for (com.chefencasa.app.entities.Receta receta : recetasDelUsuario) {
				RecetaProto.Receta recetaProto = convertirRecetaARecetaProto(receta);
				response.addReceta(recetaProto);
			}
			if (recetasDelUsuario.isEmpty()) {
				response.setMensaje("No se encontraron recetas.");
			}
			response.setMensaje("Recetas obtenidas exitosamente");
		} catch (Exception e) {
			response.setMensaje("Ha ocurrido un error al obtener las recetas del usuario.");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	@Transactional
	public void updateReceta(UpdateRecetaRequest request, StreamObserver<RecetaResponse> responseObserver) {
		RecetaResponse.Builder response = RecetaResponse.newBuilder();
		try {
			com.chefencasa.app.entities.Receta receta = recetaRepository.findById(request.getIdReceta());
			if (!request.getTituloReceta().isEmpty()) {
				receta.setTituloReceta(request.getTituloReceta());
			}
			if (!request.getDescripcion().isEmpty()) {
				receta.setDescripcion(request.getDescripcion());
			}
			if (!request.getCategoria().isEmpty()) {
				receta.setCategoria(categoriaRepository.findByCategoria(request.getCategoria()));
			}
			if (!request.getPasos().isEmpty()) {
				receta.setPasos(request.getPasos());
			}
			if (request.getIngredientesCount() > 0) {
				for (com.chefencasa.app.entities.Ingrediente ingrediente : receta.getIngredientes()) {
					ingrediente.getRecetas().remove(receta);
				}
				receta.getIngredientes().clear();
				receta.setIngredientes(ingresarIngredientesYObtenerLista(request.getIngredientesList(), receta));
			}
			if (request.getTiempoPreparacion() != 0) {
				receta.setTiempoPreparacion(request.getTiempoPreparacion());
			}
			if (!request.getFoto1().isEmpty()) {
				receta.setFoto1(request.getFoto1());
			}
			if (!request.getFoto2().isEmpty()) {
				receta.setFoto2(request.getFoto2());
			}
			if (!request.getFoto3().isEmpty()) {
				receta.setFoto3(request.getFoto3());
			}
			if (!request.getFoto4().isEmpty()) {
				receta.setFoto4(request.getFoto4());
			}
			if (!request.getFoto5().isEmpty()) {
				receta.setFoto5(request.getFoto5());
			}
			recetaRepository.save(receta);
			response.setReceta(convertirRecetaARecetaProto(receta));
			response.setMensaje("Receta actualizada satisfactoriamente");
		} catch (Exception e) {
			response.setMensaje("Ha ocurrido un error al actualizar la receta.");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	private com.chefencasa.app.entities.Receta convertirRecetaProtoAReceta(RecetaProto.Receta recetaProto) {
		com.chefencasa.app.entities.Receta receta = new com.chefencasa.app.entities.Receta();

		receta.setId(recetaProto.getIdReceta());
		receta.setTituloReceta(recetaProto.getTituloReceta());
		receta.setDescripcion(recetaProto.getDescripcion());
		receta.setPasos(recetaProto.getPasos());
		receta.setTiempoPreparacion(recetaProto.getTiempoPreparacion());
		receta.setFoto1(recetaProto.getFoto1());
		receta.setFoto2(recetaProto.getFoto2());
		receta.setFoto3(recetaProto.getFoto3());
		receta.setFoto4(recetaProto.getFoto4());
		receta.setFoto5(recetaProto.getFoto5());

		Timestamp fechaCreacionProto = recetaProto.getFechaCreacion();
		Instant instant = Instant.ofEpochSecond(fechaCreacionProto.getSeconds(), fechaCreacionProto.getNanos());
		LocalDateTime fechaCreacion = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
		receta.setFechaCreacion(fechaCreacion);

		receta.setUser(userRepository.findById(recetaProto.getIdUsuario()));
		receta.setCategoria(categoriaRepository.findByCategoria(recetaProto.getCategoria()));

		receta.setIngredientes(convertirIngredientesProtoASet(recetaProto.getIngredientesList()));

		return receta;
	}

	private RecetaProto.Receta convertirRecetaARecetaProto(com.chefencasa.app.entities.Receta receta) {

		RecetaProto.Receta.Builder recetaProtoBuilder = RecetaProto.Receta.newBuilder();
		recetaProtoBuilder.setIdReceta(receta.getId());
		recetaProtoBuilder.setIdUsuario(receta.getUser().getId());
		recetaProtoBuilder.setTituloReceta(receta.getTituloReceta());
		recetaProtoBuilder.setDescripcion(receta.getDescripcion());
		recetaProtoBuilder.setCategoria(receta.getCategoria().getCategoria());
		recetaProtoBuilder.setPasos(receta.getPasos());
		recetaProtoBuilder.setTiempoPreparacion(receta.getTiempoPreparacion());
		recetaProtoBuilder.setFoto1(receta.getFoto1());
		recetaProtoBuilder.setFoto2(receta.getFoto2());
		recetaProtoBuilder.setFoto3(receta.getFoto3());
		recetaProtoBuilder.setFoto4(receta.getFoto4());
		recetaProtoBuilder.setFoto5(receta.getFoto5());

		LocalDateTime fechaCreacion = receta.getFechaCreacion();
		Timestamp fechaCreacionProto = Timestamp.newBuilder().setSeconds(fechaCreacion.toEpochSecond(ZoneOffset.UTC))
				.setNanos(fechaCreacion.getNano()).build();
		recetaProtoBuilder.setFechaCreacion(fechaCreacionProto);

		Set<String> nombresIngredientes = new HashSet<>();
		for (com.chefencasa.app.entities.Ingrediente ingrediente : receta.getIngredientes()) {
			nombresIngredientes.add(ingrediente.getIngrediente());
		}
		recetaProtoBuilder.addAllIngredientes(nombresIngredientes);

		return recetaProtoBuilder.build();
	}

	private Set<com.chefencasa.app.entities.Ingrediente> convertirIngredientesProtoASet(
			List<String> ingredientesProto) {
		Set<com.chefencasa.app.entities.Ingrediente> ingredientes = new HashSet<>();
		for (String ingredienteNombre : ingredientesProto) {
			com.chefencasa.app.entities.Ingrediente ingrediente = new com.chefencasa.app.entities.Ingrediente();
			ingrediente.setIngrediente(ingredienteNombre);
			ingredientes.add(ingrediente);
		}
		return ingredientes;
	}

	@Transactional
	public Set<com.chefencasa.app.entities.Ingrediente> ingresarIngredientesYObtenerLista(
			List<String> ingredientesProto, com.chefencasa.app.entities.Receta receta) {
		Set<com.chefencasa.app.entities.Ingrediente> ingredientesEnDB = new HashSet<>();

		for (String nombreIngrediente : ingredientesProto) {
			com.chefencasa.app.entities.Ingrediente ingrediente = ingredienteRepository
					.findByIngrediente(nombreIngrediente);
			if (ingrediente == null) {
				ingrediente = new com.chefencasa.app.entities.Ingrediente();
				ingrediente.setIngrediente(nombreIngrediente);
				ingrediente.setRecetas(new HashSet<>());
				ingredienteRepository.save(ingrediente);
			}
			receta.getIngredientes().add(ingrediente);
			ingrediente.getRecetas().add(receta);
			ingredientesEnDB.add(ingrediente);

		}

		return ingredientesEnDB;
	}

}
