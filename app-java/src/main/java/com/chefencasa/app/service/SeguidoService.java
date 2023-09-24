package com.chefencasa.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chefencasa.app.entities.Receta;
import com.chefencasa.app.entities.Seguido;
import com.chefencasa.app.repository.SeguidoRepository;
import com.chefencasa.app.repository.UserRepository;
import com.chefencasa.model.CategoriaProto;
import com.chefencasa.model.IngredienteProto;
import com.chefencasa.model.RecetaProto;
import com.chefencasa.model.SeguidoProto;
import com.chefencasa.model.SeguidosServiceGrpc;
import com.chefencasa.model.UserProto;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class SeguidoService extends SeguidosServiceGrpc.SeguidosServiceImplBase { 
    AtomicInteger id = new AtomicInteger();

    @Autowired
	@Qualifier("seguidoRepository")
	private SeguidoRepository seguidoRepository;

    @Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(RecetaService.class);


    @Override
    public void addSeguido(SeguidoProto.Seguido request, StreamObserver<SeguidoProto.Seguido> responseObserver) {
       
        try {
			Seguido seguido = new Seguido(userRepository.findById(request.getUser().getId()), userRepository.findById(request.getSeguido().getId()));

            seguidoRepository.save(seguido);
            
		} catch (Exception e) {
			try {
                throw new Exception("No se pudo completar la operación,error al ingresar los datos o el seguidor ya existe");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}
        SeguidoProto.Seguido a = SeguidoProto.Seguido.newBuilder()
            .setId(request.getId())
            .setUser(request.getUser())
            .setSeguido(request.getSeguido())
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }

    @Transactional
    public void deleteSeguido(SeguidoProto.Seguido request, StreamObserver<SeguidoProto.Seguido> responseObserver) {
       
        try {
			Seguido seguido = seguidoRepository.findById(request.getId()).get();
            System.out.println("Seguido a eliminar"+seguido);
            seguidoRepository.delete(seguido);
            
		} catch (Exception e) {
            logger.error("Error al eliminar Seguido", e);
        }

        SeguidoProto.Seguido a = SeguidoProto.Seguido.newBuilder()
            .setId(request.getId())
            .build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }

    @Transactional
    public void findAllById(SeguidoProto.Seguido request, StreamObserver<SeguidoProto.Seguidos> responseObserver) {
		try {
			
			List<SeguidoProto.Seguido> seguidodb = new ArrayList<>();
            int usuarioId = request.getUser().getId();
			logger.info("Usuario ID: " + usuarioId); 

            List<Seguido> seguidos = seguidoRepository.findAllSeguidosByUserId(usuarioId);

			for (Seguido seguido : seguidos) {
                
                SeguidoProto.Seguido seguidoProto = SeguidoProto.Seguido.newBuilder()
                        .setId(seguido.getId())
						.setUser(UserProto.User.newBuilder()
                                .setId(seguido.getSeguido().getId())
								.setNombre(seguido.getSeguido().getNombre())
                                .setApellido(seguido.getSeguido().getApellido())
                                .setFotoPerfil(seguido.getSeguido().getFotoPerfil())
                                .setEmail(seguido.getSeguido().getEmail())
								.build())
						.build();
				seguidodb.add(seguidoProto);
			}
			
			SeguidoProto.Seguidos s = SeguidoProto.Seguidos.newBuilder()
					.addAllSeguido(seguidodb)
					.build();
		
			responseObserver.onNext(s);
			responseObserver.onCompleted();
	
		} catch (Exception e) {
			logger.info("Error al traer los Seguidos"+e.getMessage(), e);
		}
	}

}

