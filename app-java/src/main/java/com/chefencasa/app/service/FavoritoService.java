package com.chefencasa.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;

import com.chefencasa.app.dto.PopularidadRecetaDTO;
import com.chefencasa.app.dto.PopularidadUsuarioDTO;
import com.chefencasa.app.entities.Favorito;
import com.chefencasa.app.entities.Receta;
import com.chefencasa.app.repository.FavoritoRepository;
import com.chefencasa.app.repository.RecetaRepository;
import com.chefencasa.app.repository.UserRepository;
import com.chefencasa.model.CategoriaProto;
import com.chefencasa.model.FavoritoProto;
import com.chefencasa.model.FavoritosServiceGrpc;
import com.chefencasa.model.IngredienteProto;
import com.chefencasa.model.RecetaProto;
import com.chefencasa.model.UserProto;
import com.google.gson.Gson;

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

    // Inyecta el KafkaTemplate
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate; 
    
    Logger logger = LoggerFactory.getLogger(FavoritoService.class);


    @Override
    public void addFavorito(FavoritoProto.Favorito request, StreamObserver<FavoritoProto.Favorito> responseObserver) {
       
        try {

            boolean favoritoExistente = favoritoRepository.existsByUserAndReceta(userRepository.findById(request.getUser().getId()), recetaRepository.findById(request.getReceta().getIdReceta()));
            
            if (!favoritoExistente) {
                Favorito favorito = new Favorito(userRepository.findById(request.getUser().getId()), recetaRepository.findById(request.getReceta().getIdReceta()));
                favoritoRepository.save(favorito);
            }
            else{
                // Si el favorito ya existe, envía una respuesta vacía al cliente
                FavoritoProto.Favorito a = FavoritoProto.Favorito.newBuilder().build();
                responseObserver.onNext(a);
                responseObserver.onCompleted();
                return; // Sale de la función sin enviar otra respuesta
            }

            FavoritoProto.Favorito a = FavoritoProto.Favorito.newBuilder()
                .setId(request.getId())
                .setUser(UserProto.User.newBuilder().setId(request.getUser().getId()))
                .setReceta(RecetaProto.Receta.newBuilder().setIdReceta(request.getReceta().getIdReceta()).build())
                .build();
            responseObserver.onNext(a);
            responseObserver.onCompleted();

            // Creamos un objeto PopularidadRecetaDTO para enviar como JSON
            String mensaje = new Gson().toJson(new PopularidadRecetaDTO(
                request.getReceta().getIdReceta(),
                "+1"
            ));

            kafkaTemplate.send("popularidadReceta",mensaje);

            // Creamos un objeto PopularidadRecetaDTO para enviar como JSON
            String mensaje2 = new Gson().toJson(new PopularidadUsuarioDTO(
                recetaRepository.findById(request.getReceta().getIdReceta()).getUser().getNombre(),
                "+1"
            ));

            kafkaTemplate.send("popularidadUsuario",mensaje2);

        } catch (Exception e) {
            logger.error("Error al agregar Favorito", e);
        }

    }

    @Override
    public void deleteFavorito(FavoritoProto.Favorito request, StreamObserver<FavoritoProto.Favorito> responseObserver) {
       
        try {
			Favorito favorito = favoritoRepository.findById(request.getId()).get();
            // Creamos un objeto PopularidadRecetaDTO para enviar como JSON
            String mensaje = new Gson().toJson(new PopularidadRecetaDTO(
                favoritoRepository.findById(request.getId()).get().getReceta().getId(),
                "-1"
            ));

            kafkaTemplate.send("popularidadReceta",mensaje);


            // Creamos un objeto PopularidadRecetaDTO para enviar como JSON
            String mensaje2 = new Gson().toJson(new PopularidadUsuarioDTO(
                favoritoRepository.findById(request.getId()).get().getReceta().getUser().getNombre(),
                "-1"
            ));

            kafkaTemplate.send("popularidadUsuario",mensaje2);


            favoritoRepository.delete(favorito);
            
		} catch (Exception e) {
            logger.error("Error al eliminar Favorito", e);
        }
        
        FavoritoProto.Favorito a = FavoritoProto.Favorito.newBuilder()
            .setId(request.getId())
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }

    @Override
	public void findAllById(FavoritoProto.Favorito request, StreamObserver<FavoritoProto.Favoritos> responseObserver) {
        try {
            
            int usuarioId = request.getUser().getId();
            
            List<Favorito> favoritos = favoritoRepository.findAllFavoritosByUserId(usuarioId);
            List<FavoritoProto.Favorito> favoritodb = new ArrayList<>();
    
            for (Favorito favorito : favoritos) {

                Receta receta = favorito.getReceta();

                List<IngredienteProto.Ingrediente> lstIngredientes = new ArrayList<>();
	
				if (receta.getIngredientes() != null) {
					lstIngredientes.addAll(receta.getIngredientes().stream()
							.map(ingrediente -> IngredienteProto.Ingrediente.newBuilder()
									.setId(ingrediente.getId())
									.setNombre(ingrediente.getNombre())
									.build())
							.collect(Collectors.toList()));
				}

                FavoritoProto.Favorito favoritoProto = FavoritoProto.Favorito.newBuilder()
                        .setId(favorito.getId())
                        .setReceta(RecetaProto.Receta.newBuilder()
                            .setIdReceta(receta.getId())
                            .setTituloReceta(receta.getTituloReceta())
                            .setDescripcion(receta.getDescripcion())
                            .setTiempoPreparacion(receta.getTiempoPreparacion())
                            .setPasos(receta.getPasos())
                            .setFoto1(receta.getFoto1())
                            .setFoto2(receta.getFoto2())
                            .setFoto3(receta.getFoto3())
                            .setFoto4(receta.getFoto4())
                            .setCategoria(CategoriaProto.Categoria.newBuilder()
								.setCategoria(receta.getCategoria().getCategoria())
								.build())
                            .addAllIngredientes(lstIngredientes))
                        .setUser(UserProto.User.newBuilder())
                        .build();
    
                favoritodb.add(favoritoProto);
            }

            
            FavoritoProto.Favoritos a = FavoritoProto.Favoritos.newBuilder()
                    .addAllFavorito(favoritodb)
                    .build();
        
            responseObserver.onNext(a);
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.info("Error al traer Favoritos", e);
        }
    }
}

