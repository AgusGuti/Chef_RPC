package com.chefencasa.app.service;

import net.devh.boot.grpc.server.service.GrpcService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.Categoria;
import com.chefencasa.app.repository.CategoriaRepository;
import com.chefencasa.app.repository.RecetaRepository;
import com.chefencasa.app.repository.UserRepository;
import com.chefencasa.model.RecetaProto;
import com.chefencasa.model.RecetaProto.Empty;
import com.chefencasa.model.RecetaProto.Receta;
import com.chefencasa.model.RecetaProto.RecetaFiltro;
import com.chefencasa.model.RecetaProto.RecetaId;
import com.chefencasa.model.RecetaProto.RecetaResponse;
import com.chefencasa.model.RecetaProto.RecetasResponse;
import com.chefencasa.model.RecetaProto.UsuarioId;
import com.chefencasa.model.RecetasServiceGrpc;

import io.grpc.stub.StreamObserver;

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

	@Override
	public void addReceta(Receta request, StreamObserver<RecetaResponse> responseObserver) {
		RecetaResponse.Builder response = RecetaResponse.newBuilder();
		try {
			Receta receta = response.getReceta();
			Instant instant = Instant.ofEpochSecond(receta.getFechaCreacion().getSeconds(),
					receta.getFechaCreacion().getNanos());
			LocalDateTime localDateTime = instant.atZone(ZoneOffset.UTC).toLocalDateTime();
			// hay que ver la zona horaria si se guarda bien
			Categoria cat = categoriaRepository.findById(receta.getCategoria()).orElse(null);
			if (cat==null) {
				cat = categoriaRepository.save(new Categoria(receta.getCategoria()));	
			}
			recetaRepository.save(new com.chefencasa.app.entities.Receta(userRepository.findById(receta.getIdUsuario()),
					convertirIngredientesProtoASet(receta.getIngredientesList()), cat, receta.getTituloReceta(),
					receta.getDescripcion(), receta.getPasos(), receta.getTiempoPreparacion(), localDateTime,
					receta.getFoto1(), receta.getFoto2(), receta.getFoto3(), receta.getFoto4(), receta.getFoto5()));
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
			/*
			 * List<Receta> recetas =
			 * RecetaDao.getByFilter(request.getCategoria(),request.getNombre(),request.
			 * getIngredientesList(),request.getTiempoPrepDesde(),request.getTiempoPrepHasta
			 * ()); //se tiene que hacer en el Dao
			 * 
			 * response.addAllReceta(recetas);
			 * 
			 * if (recetas.isEmpty()) {
			 * response.setMensaje("No se encontraron recetas que coincidan con el filtro."
			 * ); } else { response.setMensaje("Recetas obtenidas exitosamente."); }
			 */
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
			/*
			 * List<Receta> recetas = RecetaDao.getAllRecetas(); //hay que hacer el dao de
			 * receta response.addAllReceta(recetas);
			 * 
			 * if (recetas.isEmpty()) { response.setMensaje("No se encontraron recetas."); }
			 * else { response.setMensaje("Recetas obtenidas exitosamente."); }
			 */
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

			/*
			 * List<Receta> recetas = RecetaDao.getAllRecetasByUser(userId); //falta hacer
			 * el DAO response.addAllReceta(recetas);
			 * 
			 * 
			 * if (recetas.isEmpty()) {
			 * response.setMensaje("No se encontraron recetas para el usuario con ID " +
			 * userId); } else { response.setMensaje("Recetas del usuario con ID " + userId
			 * + " obtenidas exitosamente."); }
			 */

		} catch (Exception e) {
			response.setMensaje("Ha ocurrido un error al obtener las recetas del usuario.");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void updateReceta(RecetaId request, StreamObserver<RecetaResponse> responseObserver) {
		RecetaResponse.Builder response = RecetaResponse.newBuilder();
		try {
			int recetaId = request.getIdReceta();
			// hay que hacer el DAO
			/*
			 * boolean actualizacionExitosa = RecetaDao.updateReceta(recetaId);
			 * 
			 * if (actualizacionExitosa) { response.setMensaje("Receta con ID " + recetaId +
			 * " actualizada exitosamente."); } else {
			 * response.setMensaje("No se encontró una receta con ID " + recetaId +
			 * " para actualizar."); }
			 */
		} catch (Exception e) {
			response.setMensaje("Ha ocurrido un error al actualizar la receta.");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	/*
	private com.chefencasa.app.entities.Receta convertirRecetaProtoAReceta(RecetaProto.Receta recetaProto) {
		com.chefencasa.app.entities.Receta receta = new com.chefencasa.app.entities.Receta();
		receta.setTituloReceta(recetaProto.getTituloReceta());
		receta.setIngredientes(convertirIngredientesProtoASet(recetaProto.getIngredientesList()));
		receta.setDescripcion(recetaProto.getDescripcion());
		receta.setPasos(recetaProto.getPasos());
		receta.setTiempoPreparacion(recetaProto.getTiempoPreparacion());
		// receta.setFechaCreacion(recetaProto.getFechaCreacion());
		receta.setFoto1(recetaProto.getFoto1());
		receta.setFoto2(recetaProto.getFoto2());
		receta.setFoto3(recetaProto.getFoto3());
		receta.setFoto4(recetaProto.getFoto4());
		receta.setFoto5(recetaProto.getFoto5());
		return receta;
	}

	private RecetaProto.Receta convertirRecetaARecetaProto(Receta receta) {
		return RecetaProto.Receta.newBuilder().setIdReceta(receta.getIdReceta()).setIdUsuario(receta.getIdUsuario())
				.setTituloReceta(receta.getTituloReceta()).setDescripcion(receta.getDescripcion())
				....
				.build();
	}
	*/

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

}
