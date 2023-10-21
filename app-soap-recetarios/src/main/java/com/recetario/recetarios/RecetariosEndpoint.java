package com.recetario.recetarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.recetario.recetarios.entities.Recers;
import com.recetario.recetarios.entities.Recetario;
import com.recetario.recetarios.service.RecetarioService;
import com.recetario.recetarios.service.RecersService;
import io.spring.guides.gs_producing_web_service.AgregarRecetarioRequest;
import io.spring.guides.gs_producing_web_service.AgregarRecetarioResponse;
import io.spring.guides.gs_producing_web_service.TraerRecetariosPorUsuarioRequest;
import io.spring.guides.gs_producing_web_service.TraerRecetariosPorUsuarioResponse;
import io.spring.guides.gs_producing_web_service.TraerRecetariosRequest;
import io.spring.guides.gs_producing_web_service.TraerRecetariosResponse;
import io.spring.guides.gs_producing_web_service.EliminarRecetarioRequest;
import io.spring.guides.gs_producing_web_service.EliminarRecetarioResponse;
import io.spring.guides.gs_producing_web_service.AgregarRecetasEnRecetarioRequest;
import io.spring.guides.gs_producing_web_service.AgregarRecetasEnRecetarioResponse;
import io.spring.guides.gs_producing_web_service.TraerRecetasPorRecetariosRequest;
import io.spring.guides.gs_producing_web_service.TraerRecetasPorRecetariosResponse;

import org.springframework.beans.factory.annotation.Qualifier;

@Endpoint
public class RecetariosEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    
    private RecetarioService recetarioService;
    private RecersService recersService;

    @Autowired
    public RecetariosEndpoint(@Qualifier("recetarioService") RecetarioService recetarioService, RecersService recersService) {
        this.recetarioService = recetarioService;
        this.recersService = recersService;
    }
   
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "agregarRecetarioRequest")
    @ResponsePayload
    public AgregarRecetarioResponse agregarRecetario(@RequestPayload AgregarRecetarioRequest request) {
        AgregarRecetarioResponse response = new AgregarRecetarioResponse();

        response.setConfirmacion("no se pudo agregar el recetario");

        try {
            recetarioService.addRecetario(request.getNombre(), request.getUsuarioId());
            response.setConfirmacion("se pudo agregar el recetario");
        }catch(Exception e) {
			System.out.println("ERROR al agregar el recetario:\n\n" + e.getMessage());
		}
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TraerRecetariosRequest")
    @ResponsePayload
    public TraerRecetariosResponse listarRecetarios(@RequestPayload TraerRecetariosRequest request) {
        TraerRecetariosResponse response = new TraerRecetariosResponse();

        List<Recetario> recetarios = recetarioService.TraerRecetarios();
        for (Recetario recetario : recetarios){
            io.spring.guides.gs_producing_web_service.Recetario recetario_xsd = new io.spring.guides.gs_producing_web_service.Recetario();
            recetario_xsd.setId(recetario.getId());
            recetario_xsd.setNombre(recetario.getNombre());
            recetario_xsd.setUsuarioId(recetario.getUsuarioId());
           
            response.getRecetarios().add(recetario_xsd);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TraerRecetariosPorUsuarioRequest")
    @ResponsePayload
    public TraerRecetariosPorUsuarioResponse listarRecetarios(@RequestPayload TraerRecetariosPorUsuarioRequest request) {
        TraerRecetariosPorUsuarioResponse response = new TraerRecetariosPorUsuarioResponse();

        List<Recetario> recetarios = recetarioService.TraerRecetariosPorUsuario(request.getUsuarioId());
        for (Recetario recetario : recetarios){
            io.spring.guides.gs_producing_web_service.Recetario recetario_xsd = new io.spring.guides.gs_producing_web_service.Recetario();
            recetario_xsd.setId(recetario.getId());
            recetario_xsd.setNombre(recetario.getNombre());
            recetario_xsd.setUsuarioId(recetario.getUsuarioId());
           
            response.getRecetarios().add(recetario_xsd);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EliminarRecetarioRequest")
    @ResponsePayload
    public EliminarRecetarioResponse EliminarRecetario(@RequestPayload EliminarRecetarioRequest request) {
        EliminarRecetarioResponse response = new EliminarRecetarioResponse();

        response.setConfirmacion("no se encuentra el recetario a Eliminar");

        try {
            recetarioService.deleteRecetario(request.getUsuarioId());
            recersService.eliminarRecetarios(request.getUsuarioId());
            response.setConfirmacion("recetario eliminado");
        }catch(Exception e) {
			System.out.println("ERROR al eliminar el recetario:\n\n" + e.getMessage());
		}
        return response;
    }

}









