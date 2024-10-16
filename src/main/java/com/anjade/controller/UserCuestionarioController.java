package com.anjade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.anjade.entity.CuestionarioRespuestaDto;
import com.anjade.entity.UserCuestionarioDto;
import com.anjade.service.UserCuestionarioService;

@RestController
@RequestMapping("/api/v1/user-cuestionario")
public class UserCuestionarioController {

    @Autowired
    private UserCuestionarioService userCuestionarioService;

    @GetMapping("/exists/{userId}")
    public ResponseEntity<Boolean> existsCuestionarioForUser(@PathVariable Long userId) {
        boolean exists = userCuestionarioService.existsCuestionarioForUser(userId);
        return ResponseEntity.ok(exists);
    }

    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CuestionarioRespuestaDto>> getCuestionarioByUserId(@PathVariable Long userId) {
        List<CuestionarioRespuestaDto> cuestionarios = (List<CuestionarioRespuestaDto>) userCuestionarioService.getCuestionarioByUserId(userId);
        return ResponseEntity.ok(cuestionarios);
    }
}