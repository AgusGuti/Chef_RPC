package com.moddenuncias.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.moddenuncias.app.entities.Denuncia;
import com.moddenuncias.app.entities.Receta;
import com.moddenuncias.app.entities.User;
import com.moddenuncias.app.repository.DenunciaRepository;
import com.moddenuncias.app.repository.RecetaRepository;
import com.moddenuncias.app.repository.UserRepository;
import com.moddenuncias.model.DenunciaProto;
import com.moddenuncias.model.DenunciaServiceGrpc;
import com.moddenuncias.model.IngredienteProto;
import com.moddenuncias.model.RecetaProto;
import com.moddenuncias.model.CategoriaProto;
import com.moddenuncias.model.UserProto;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class DenunciaService extends DenunciaServiceGrpc.DenunciaServiceImplBase { 
    AtomicInteger id = new AtomicInteger();


	@Autowired
	@Qualifier("denunciaRepository")
	private DenunciaRepository denunciaRepository;

    @Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

    @Autowired
	@Qualifier("recetaRepository")
	private RecetaRepository recetaRepository;

   
    @Override
	public void addDenuncia(DenunciaProto.Denuncia request, StreamObserver<DenunciaProto.Denuncia> responseObserver) {
		 
		try {
			Denuncia denuncia = new Denuncia(userRepository.findById(request.getUserId().getId()),
            recetaRepository.findById(request.getRecetaId()).get(),
            request.getMotivo()
			);
			
			denunciaRepository.save(denuncia);

		} catch (Exception e) {
			System.err.println("Error al agregar la denuncia: " + e.getMessage());

			try {
                throw new Exception("No se pudo completar la operación,error al ingresar los datos o la denuncia ya existe");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}
    }

    @Override
    public void traerDenuncia(DenunciaProto.Denuncia request,StreamObserver<DenunciaProto.Denuncia> responseObserver) {

        Denuncia denuncia = denunciaRepository.findById(request.getId());

        DenunciaProto.Denuncia a = DenunciaProto.Denuncia.newBuilder()
                    .setId(denuncia.getId())
                    .build();

        responseObserver.onNext(a);
        responseObserver.onCompleted();
        
    }

   	@Override
	public void findUnresolved(Empty request, StreamObserver<DenunciaProto.Denuncias> responseObserver) {
        
        List<DenunciaProto.Denuncia> denunciadb = new ArrayList<>();        

        for (Denuncia denuncia : denunciaRepository.findUnresolved()) {

            Receta receta = denuncia.getReceta();

            List<IngredienteProto.Ingrediente> lstIngredientes = new ArrayList<>();
	
				if (receta.getIngredientes() != null) {
					lstIngredientes.addAll(receta.getIngredientes().stream()
							.map(ingrediente -> IngredienteProto.Ingrediente.newBuilder()
									.setId(ingrediente.getId())
									.setNombre(ingrediente.getNombre())
									.build())
							.collect(Collectors.toList()));
				}

            DenunciaProto.Denuncia denunciaProto = DenunciaProto.Denuncia.newBuilder()
                    .setId(denuncia.getId())
                    .setUserId(UserProto.User.newBuilder()
                                .setId(denuncia.getUser().getId())
								.setNombre(denuncia.getUser().getNombre())
                                .setApellido(denuncia.getUser().getApellido())
                                .setFotoPerfil(denuncia.getUser().getFotoPerfil())
                                .setEmail(denuncia.getUser().getEmail())
								.build())
                    .setRecetaId(RecetaProto.Receta.newBuilder()
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
                    .setMotivo(denuncia.getMotivo())
                    .setResuelta(denuncia.getResuelta())
                    .build();
            denunciadb.add(denunciaProto);
        }

        DenunciaProto.Denuncias a = DenunciaProto.Denuncias.newBuilder()
            .addAllDenuncia(denunciadb)
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }

}

