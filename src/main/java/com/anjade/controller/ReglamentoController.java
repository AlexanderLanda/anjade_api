package com.anjade.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.anjade.entity.AttachmentDto;
import com.anjade.entity.DeportesDto;
import com.anjade.entity.ReglamentosDto;
import com.anjade.entity.ReportDto;
import com.anjade.service.ReglamentoService;
import com.anjade.serviceImpl.ReglamentoServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


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
    public List<ReglamentosDto> saveReglamento( @RequestPart("deporte") String deporte, @RequestPart(value = "files", required = false) List<MultipartFile> files) {
    	
    	List<ReglamentosDto> reglamentos = new ArrayList<ReglamentosDto>();
    	ObjectMapper objectMapper = new ObjectMapper();
		try {
		
    	
    	for (MultipartFile file : files) {
    		ReglamentosDto reglamento = new ReglamentosDto();
    		reglamento.setName(file.getOriginalFilename());
    		reglamento.setType(file.getContentType());
    		reglamento.setPath("/ficheros/documentos/reglamentos_deportivos/"+file.getOriginalFilename());
            reglamento.setDeporte(deporte);
            reglamentos.add(reglamento);
            service.saveReglamento(reglamento);
            

        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reglamentos;
    }

    @DeleteMapping("/{id}")
    public void deleteReglamento(@PathVariable Long id) {
        service.deleteReglamento(id);
    }
}
