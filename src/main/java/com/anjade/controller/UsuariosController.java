package com.anjade.controller;

import java.io.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjade.entity.EstadosUsuariosDto;
import com.anjade.entity.UsuariosDto;
import com.anjade.service.EmailService;
import com.anjade.service.UsuariosService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/users")
public class UsuariosController {

	@Value("${frontend.url}") // Inyecta el valor de frontend.url
	private String frontendUrl;

	@Autowired
	private final UsuariosService usuariosService;

	@Autowired
	private EmailService emailService;

	public UsuariosController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}

	@GetMapping
	public ResponseEntity<List<UsuariosDto>> getAll() {
		List<UsuariosDto> usuarios = usuariosService.getAllUsuarios();
		return ResponseEntity.ok(usuarios);
	}

	@PostMapping
	public ResponseEntity<UsuariosDto> saveOrUpdate(@RequestBody String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UsuariosDto usuarioDto = objectMapper.readValue(json, new TypeReference<UsuariosDto>() {
			});
			System.out.println("id_user:" + usuarioDto.getId_user());
			if (usuarioDto.getId_user() == null) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
				String timestamp = LocalDateTime.now().format(formatter);
				String idAfi = "A" + timestamp.substring(timestamp.length() - 6, timestamp.length()); // ID único del
																										// pedido

				usuarioDto.setIdAfiliacion(idAfi);
				EstadosUsuariosDto estado = new EstadosUsuariosDto(3L, "pendiente de pago");
				usuarioDto.setEstadoCuenta(estado);
			}

			UsuariosDto usuarioGuardado = usuariosService.saveOrUpdate(usuarioDto);
			emailService.sendWelcomeEmail(usuarioGuardado.getCorreo(), usuarioGuardado.getIdAfiliacion());
			return new ResponseEntity<>(usuarioGuardado, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		usuariosService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
