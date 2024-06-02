package com.anjade.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjade.entity.UsuariosDto;
import com.anjade.service.UsuariosService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Value("${frontend.url}") // Inyecta el valor de frontend.url
    private String frontendUrl;
	
    @Autowired
    private UsuariosService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<UsuariosDto> user = userService.login(loginRequest.getIdAfiliacion(), loginRequest.getPassword());
        if (user.isPresent()) {
            // Aquí puedes generar y devolver un JWT si estás utilizando autenticación basada en tokens
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas o usuario no autorizado");
    }
    
    public static class LoginRequest {
        private String idAfiliacion;
        private String password;
        
        
        
		public LoginRequest(String idAfiliacion, String password) {
			super();
			this.idAfiliacion = idAfiliacion;
			this.password = password;
		}
		public String getIdAfiliacion() {
			return idAfiliacion;
		}
		public void setIdAfiliacion(String idAfiliacion) {
			this.idAfiliacion = idAfiliacion;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

        
        // Getters y setters
        // ...
    }
}
