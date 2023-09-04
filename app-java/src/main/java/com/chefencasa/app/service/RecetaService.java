package com.chefencasa.app.service;

import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.repository.RecetaRepository;
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

	@Override
	public void addReceta(Receta request, StreamObserver<RecetaResponse> responseObserver) {
		RecetaResponse.Builder response = RecetaResponse.newBuilder();
		try {
			//Receta receta = RecetaDao.agregarReceta(request); //hay que crear el RecetaDao e incluir el metodo de agregar receta para que esto funcione
			//response.setReceta(receta); 
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
	        List<Receta> recetas = RecetaDao.getByFilter(request.getCategoria(),request.getNombre(),request.getIngredientesList(),request.getTiempoPrepDesde(),request.getTiempoPrepHasta());
			//se tiene que hacer en el Dao

	        response.addAllReceta(recetas);

	        if (recetas.isEmpty()) {
	            response.setMensaje("No se encontraron recetas que coincidan con el filtro.");
	        } else {
	            response.setMensaje("Recetas obtenidas exitosamente.");
	        }
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
	        List<Receta> recetas = RecetaDao.getAllRecetas();
	        //hay que hacer el dao de receta
	        response.addAllReceta(recetas);

	        if (recetas.isEmpty()) {
	            response.setMensaje("No se encontraron recetas.");
	        } else {
	            response.setMensaje("Recetas obtenidas exitosamente.");
	        }
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
	        List<Receta> recetas = RecetaDao.getAllRecetasByUser(userId);
	        //falta hacer el DAO
	        response.addAllReceta(recetas);
	        

	        if (recetas.isEmpty()) {
	            response.setMensaje("No se encontraron recetas para el usuario con ID " + userId);
	        } else {
	            response.setMensaje("Recetas del usuario con ID " + userId + " obtenidas exitosamente.");
	        }
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
	        //hay que hacer el DAO
	        /*
	        boolean actualizacionExitosa = RecetaDao.updateReceta(recetaId);

	        if (actualizacionExitosa) {
	            response.setMensaje("Receta con ID " + recetaId + " actualizada exitosamente.");
	        } else {
	            response.setMensaje("No se encontró una receta con ID " + recetaId + " para actualizar.");
	        }
	        */
	    } catch (Exception e) {
	        response.setMensaje("Ha ocurrido un error al actualizar la receta.");
	    }

	    responseObserver.onNext(response.build());
	    responseObserver.onCompleted();
	}

}
