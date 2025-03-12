package com.anjade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjade.entity.ReglamentosDto;
import com.anjade.service.ReglamentoService;
import com.anjade.serviceImpl.ReglamentoServiceImpl;


@RequestMapping("/api/v1/reglamentos")
@RestController
public class ReglamentoController {

    @Autowired
	private final ReglamentoService service;

    public ReglamentoController(ReglamentoServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReglamentosDto>> getAllReglamentos() {
        List<ReglamentosDto> reglamentos = service.getAllReglamentos();
        return ResponseEntity.ok(reglamentos);
    }


    @PostMapping
    public ReglamentosDto saveReglamento(@RequestBody ReglamentosDto reglamento) {
        return service.saveReglamento(reglamento);
    }

    @DeleteMapping("/{id}")
    public void deleteReglamento(@PathVariable Long id) {
        service.deleteReglamento(id);
    }
}
