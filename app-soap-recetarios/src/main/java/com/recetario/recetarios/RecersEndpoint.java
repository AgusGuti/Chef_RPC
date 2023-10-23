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



@Endpoint
public class RecersEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private RecersService recersService;

    @Autowired
    public RecersEndpoint(RecersService recersService){
        this.recersService = recersService;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AgregarRecetasEnRecetarioRequest")
    @ResponsePayload
    public AgregarRecetasEnRecetarioResponse AgregarRecetasEnRecetario(@RequestPayload AgregarRecetasEnRecetarioRequest request) {
        AgregarRecetasEnRecetarioResponse response = new AgregarRecetasEnRecetarioResponse();

        response.setConfirmacion("no se pudo agregar receta al recetario");

        try {
            recersService.addRecetaEnRecetario(request.getRecetaId(), request.getRecetarioId());
            response.setConfirmacion("receta agregada al recetario");
        }catch(Exception e) {
			System.out.println("ERROR al agregar receta al recetario:\n\n" + e.getMessage());
		}
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TraerRecetasPorRecetariosRequest")
    @ResponsePayload
    public TraerRecetasPorRecetariosResponse listarRecetaPorRecetarios(@RequestPayload TraerRecetasPorRecetariosRequest request) {
        TraerRecetasPorRecetariosResponse response = new TraerRecetasPorRecetariosResponse();

        List<Recers> recersss = recersService.TraerRecetasPorRecetario(request.getRecetarioId());
        for (Recers recers : recersss){
            io.spring.guides.gs_producing_web_service.Recers recers_xsd = new io.spring.guides.gs_producing_web_service.Recers();
            recers_xsd.setId(recers.getId());
            recers_xsd.setRecetaId(recers.getRecetaId());
            recers_xsd.setRecetarioId(recers.getRecetarioId());

            response.getRecers().add(recers_xsd);
        }
        return response;
    }


}









