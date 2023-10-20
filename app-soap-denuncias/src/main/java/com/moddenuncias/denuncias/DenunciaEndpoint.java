package com.moddenuncias.denuncias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.moddenuncias.denuncias.entities.Denuncia;
import com.moddenuncias.denuncias.entities.Motivo;
import com.moddenuncias.denuncias.service.DenunciaService;

import io.spring.guides.gs_producing_web_service.GetUnresolvedRequest;
import io.spring.guides.gs_producing_web_service.GetUnresolvedResponse;
import io.spring.guides.gs_producing_web_service.ResolverDenunciaRequest;
import io.spring.guides.gs_producing_web_service.ResolverDenunciaResponse;
import io.spring.guides.gs_producing_web_service.AddDenunciaRequest;
import io.spring.guides.gs_producing_web_service.AddDenunciaResponse;
import io.spring.guides.gs_producing_web_service.GetMotivosRequest;
import io.spring.guides.gs_producing_web_service.GetMotivosResponse;

@Endpoint
public class DenunciaEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private DenunciaService denunciaService;

	@Autowired
	public DenunciaEndpoint(DenunciaService denunciaService) {
		this.denunciaService = denunciaService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUnresolvedRequest")
	@ResponsePayload
	public GetUnresolvedResponse getUnresolved (@RequestPayload GetUnresolvedRequest request) {
		GetUnresolvedResponse response = new GetUnresolvedResponse();

		List<Denuncia> lista_denuncia = denunciaService.findUnresolved();

		io.spring.guides.gs_producing_web_service.Denuncia denuncia_xsd = new io.spring.guides.gs_producing_web_service.Denuncia();

		io.spring.guides.gs_producing_web_service.Motivo motivo_xsd = new io.spring.guides.gs_producing_web_service.Motivo();

		for(Denuncia denuncia : lista_denuncia){

			motivo_xsd.setId(denuncia.getMotivo_id().getId());
			motivo_xsd.setMotivo(denuncia.getMotivo_id().getMotivo());

			denuncia_xsd.setId(denuncia.getId());
			denuncia_xsd.setUserId(denuncia.getUser_id());
			denuncia_xsd.setRecetaId(denuncia.getReceta_id());
			denuncia_xsd.setMotivoId(motivo_xsd);
			denuncia_xsd.setResuelta(denuncia.getResuelta());

			response.getDenuncias().add(denuncia_xsd);
		}

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMotivosRequest")
	@ResponsePayload
	public GetMotivosResponse getMotivos(@RequestPayload GetMotivosRequest request) {
		GetMotivosResponse response = new GetMotivosResponse();
		List<Motivo> lista = denunciaService.verMotivos();

		io.spring.guides.gs_producing_web_service.Motivo motivo_xsd = new io.spring.guides.gs_producing_web_service.Motivo();

		List<io.spring.guides.gs_producing_web_service.Motivo> lista_xsd = new ArrayList<>();

		int cont = 0;

		for(Motivo motivo : lista){

			System.out.println(motivo.toString());
			System.out.println();

			motivo_xsd.setId(motivo.getId());
			motivo_xsd.setMotivo(motivo.getMotivo());

			System.out.println(motivo_xsd.toString());
			System.out.println();
			

			lista_xsd.add(cont, motivo_xsd);

			System.out.println(lista_xsd.toString());

			cont += 1;
		}

		System.out.println(lista.toString());
		System.out.println();
		System.out.println(lista_xsd.toString());

		response.getMotivos().addAll(lista_xsd);

		return response;
	}


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addDenunciaRequest")
	@ResponsePayload
	public AddDenunciaResponse addDenuncia(@RequestPayload AddDenunciaRequest request) {
		AddDenunciaResponse response = new AddDenunciaResponse();
		
		response.setConfirmacion(0);


		try {
			denunciaService.addDenuncia(request.getUserId(), request.getRecetaId(), request.getMotivoId());

			response.setConfirmacion(1);
		} catch (Exception e) {
			System.out.println("ERROR al agregar Denuncia:\n\n" + e.getMessage());
		}
		
		return response;
	}


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "resolverDenunciaRequest")
	@ResponsePayload
	public ResolverDenunciaResponse resolverDenuncia(@RequestPayload ResolverDenunciaRequest request) {
		ResolverDenunciaResponse response = new ResolverDenunciaResponse();
		
		response.setConfirmacion(0);

		try {
			denunciaService.resolverDenuncia(request.getId());

			response.setConfirmacion(1);
		} catch (Exception e) {
			System.out.println("ERROR al resolver Denuncia:\n\n" + e.getMessage());		

		}
		
		return response;
	}
}