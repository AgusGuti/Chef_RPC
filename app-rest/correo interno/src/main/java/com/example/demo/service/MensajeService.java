package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Mensaje;
import com.example.demo.entity.Tipo;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.MensajeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MensajeService {

	private final MensajeRepository repository;

	public void crearMensaje(String asunto, String cuerpo, Usuario emisor, Usuario receptor) throws Exception {
		if (asunto == null)
			throw new Exception("Error: el asunto no puede ser nulo");

		if (cuerpo == null)
			throw new Exception("Error: el cuerpo no puede ser nulo");

		if (emisor == null)
			throw new Exception("Error: el emisor no puede ser nulo");

		if (receptor == null)
			throw new Exception("Error: el receptor no puede ser nulo");

		
		if(!repository.mensajesSinContestarEntre(emisor, receptor).isEmpty() ||
				!repository.mensajesSinContestarEntre(receptor, emisor).isEmpty())
			throw new Exception("Error: el receptor debe contestar el mensaje antes de enviar otro");
		
		repository.save(new Mensaje(Tipo.MENSAJE, asunto, cuerpo, LocalDateTime.now(), emisor, receptor, null));
	}

	public List<Mensaje> mensajesEnLosQueParticipo(Usuario usuario) {
		return repository.mensajesEnLosQueParticipo(usuario);
	}
	
	public void crearRespuesta(Long idMensajeRespondido, String cuerpo) throws Exception {
		if (cuerpo == null)
			throw new Exception("Error: el cuerpo no puede ser nulo");

		Mensaje mensajeRespondido = repository.traerMensajeConDependencias(idMensajeRespondido, Tipo.MENSAJE);

		if (mensajeRespondido == null)
			throw new Exception("Error: el mensaje que se quiere responder no existe");
		
		if(mensajeRespondido.getRespuesta() != null)
			throw new Exception("Error: este mensaje ya ha sido respondido");

		Mensaje respuesta = new Mensaje(Tipo.RESPUESTA, mensajeRespondido.getAsunto(), cuerpo, LocalDateTime.now(),
				mensajeRespondido.getReceptor(), mensajeRespondido.getEmisor(), mensajeRespondido);

		mensajeRespondido.setRespuesta(respuesta);

		repository.save(respuesta);
		repository.save(mensajeRespondido);

	}

	public void modificarMensaje(Long idMensaje, String asunto, String cuerpo, LocalDateTime fechaHora, Usuario emisor,
			Usuario receptor) throws Exception {
		if (asunto == null)
			throw new Exception("Error: el asunto no puede ser nulo");

		if (cuerpo == null)
			throw new Exception("Error: el cuerpo no puede ser nulo");

		if (fechaHora == null)
			throw new Exception("Error: la fecha y hora no puede ser nula");

		if (emisor == null)
			throw new Exception("Error: el emisor no puede ser nulo");

		if (receptor == null)
			throw new Exception("Error: el receptor no puede ser nulo");

		Mensaje mensaje = repository.traerMensajeConDependencias(idMensaje, Tipo.MENSAJE);

		if (mensaje == null)
			throw new Exception("Error: el mensaje que quiere modificar no existe");

		mensaje.setAsunto(asunto);
		mensaje.setCuerpo(cuerpo);
		mensaje.setFechaHora(fechaHora);
		mensaje.setEmisor(emisor);
		mensaje.setReceptor(receptor);

		repository.save(mensaje);
	}

	public void modificarRespuesta(Long idMensaje, String cuerpo, LocalDateTime fechaHora) throws Exception {
		if (cuerpo == null)
			throw new Exception("Error: el cuerpo no puede ser nulo");

		if (fechaHora == null)
			throw new Exception("Error: la fecha y hora no puede ser nula");

		Mensaje respuesta = repository.traerMensajeConDependencias(idMensaje, Tipo.RESPUESTA);

		if (respuesta == null)
			throw new Exception("Error: la respuesta que quiere modificar no existe");

		respuesta.setCuerpo(cuerpo);
		respuesta.setFechaHora(fechaHora);

		repository.save(respuesta);

	}

	public Mensaje traerMensaje(Long idMensaje) {
		return repository.traerMensajeConDependencias(idMensaje, Tipo.MENSAJE);
	}

	public Mensaje traerRespuesta(Long idRespuesta) {
		return repository.traerMensajeConDependencias(idRespuesta, Tipo.RESPUESTA);
	}

	public void eliminarMensaje(Long idMensaje) throws Exception {
		Mensaje mensaje = repository.traerMensajeConDependencias(idMensaje, Tipo.MENSAJE);

		if (mensaje == null)
			throw new Exception("Error: el mensaje que desea borrar no existe");

		if (mensaje.getRespuesta() != null) {
			repository.delete(mensaje.getRespuesta());
			mensaje.setRespuesta(null);
		}

		repository.delete(mensaje);

	}

	public void eliminarRespuesta(Long idRespuesta) throws Exception {
		Mensaje respuesta = repository.traerMensajeConDependencias(idRespuesta, Tipo.RESPUESTA);

		if (respuesta == null)
			throw new Exception("Error: la respuesta que desea borrar no existe");

		// en este caso, la resupuesta de la respuesta es el mensaje respondido
		respuesta.getRespuesta().setRespuesta(null);

		repository.delete(respuesta);
	}

}
