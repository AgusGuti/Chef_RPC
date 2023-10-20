package main.java.com.recetario.recetarios.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.recetario.recetarios.service.RecetarioService;
import io.spring.guides.gs_producing_web_service.AgregarRecetarioRequest;
import io.spring.guides.gs_producing_web_service.AgregarRecetarioResponse;
import io.spring.guides.gs_producing_web_service.Recetario;


@Endpoint
public class RecetariosEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private RecetarioService recetarioService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "agregarRecetarioRequest")
    @ResponsePayload
    public AgregarRecetarioResponse agregarRecetario(@RequestPayload AgregarRecetarioRequest request) {
        AgregarRecetarioResponse response = new AgregarRecetarioResponse();
        recetarioService.addRecetario(request.getNombre(), request.getUsuarioId());
        Recetario recetarioxsd = new Recetario();
        recetarioxsd.setId(1);
        recetarioxsd.setNombre(request.getNombre());
        recetarioxsd.setUsuarioId(request.getUsuarioId());
        response.setRecetario(recetarioxsd);

        return response;
    }
}









