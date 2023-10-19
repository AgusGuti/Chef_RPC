package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Mensaje;

import com.example.demo.service.MensajeService;
import com.example.demo.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/mensaje")
@RequiredArgsConstructor
public class MensajeController {
	private final MensajeService mensajeService;
	private final UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Object> crearMensaje(String asunto, String cuerpo, Long idEmisor, Long idReceptor) {
		try {
			mensajeService.crearMensaje(asunto, cuerpo, usuarioService.findById(idEmisor).orElse(null),
					usuarioService.findById(idReceptor).orElse(null));
		} catch (Exception e) {
			System.err.println(e);
		}

		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}

	@PostMapping("/resp")
	public ResponseEntity<Object> crearRespuesta(Long idMensajeRespondido, String cuerpo) {

		try {
			mensajeService.crearRespuesta(idMensajeRespondido, cuerpo);
		} catch (Exception e) {
			System.err.println(e);
		}

		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> modificarMensaje(@PathVariable("id") String idMensaje, String asunto, String cuerpo,
			LocalDateTime fechaHora, Long idEmisor, Long idReceptor) {
		Long id;

		try {
			id = Long.parseLong(idMensaje);
		} catch (NumberFormatException exception) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		try {
			mensajeService.modificarMensaje(id, asunto, cuerpo, fechaHora,
					usuarioService.findById(idEmisor).orElse(null), usuarioService.findById(id).orElse(null));
		} catch (Exception e) {
			System.err.println(e);
		}

		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@PutMapping("/resp/{id}")
	public ResponseEntity<Object> modificarRespuesta(@PathVariable("id") String idMensaje, String cuerpo,
			LocalDateTime fechaHora) {
		Long id;

		try {
			id = Long.parseLong(idMensaje);
		} catch (NumberFormatException exception) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		try {
			mensajeService.modificarRespuesta(id, cuerpo, fechaHora);
		} catch (Exception e) {
			System.err.println(e);
		}

		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Mensaje> traerMensaje(@PathVariable("id") String idMensaje) {
		Long id;

		try {
			id = Long.parseLong(idMensaje);
		} catch (NumberFormatException exception) {
			return new ResponseEntity<Mensaje>(HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(mensajeService.traerMensaje(id));
	}

	@GetMapping("/resp/{id}")
	public ResponseEntity<Mensaje> traerRespuesta(@PathVariable("id") String idMensaje) {
		Long id;

		try {
			id = Long.parseLong(idMensaje);
		} catch (NumberFormatException exception) {
			return new ResponseEntity<Mensaje>(HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(mensajeService.traerRespuesta(id));
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Mensaje>> mensajesDondeParticipo(@PathVariable("id") String idUsuario){
		Long id;

		try {
			id = Long.parseLong(idUsuario);
		} catch (NumberFormatException exception) {
			return new ResponseEntity<List<Mensaje>>(HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(mensajeService.mensajesEnLosQueParticipo(usuarioService.findById(id).orElse(null)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarMensaje(@PathVariable("id") String idMensaje) {
		Long id;

		try {
			id = Long.parseLong(idMensaje);
		} catch (NumberFormatException exception) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		try {
			mensajeService.eliminarMensaje(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping("/resp/{id}")
	public ResponseEntity<Object> eliminarRespuesta(@PathVariable("id") String idMensaje) {
		Long id;

		try {
			id = Long.parseLong(idMensaje);
		} catch (NumberFormatException exception) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		try {
			mensajeService.eliminarRespuesta(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
