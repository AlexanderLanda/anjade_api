package com.anjade.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.anjade.entity.DeportesDto;
import com.anjade.entity.EstadosUsuariosDto;
import com.anjade.entity.ReportDto;
import com.anjade.entity.ReportSummaryDto;
import com.anjade.entity.UsuariosDto;
import com.anjade.serviceImpl.ReportServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
	
	private static final Logger logger = LogManager.getLogger(ReportController.class);

	
    @Autowired
    private ReportServiceImpl reportService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ReportDto> createReport(
        @RequestPart("json") String json,
        @RequestPart("files") List<MultipartFile> files) throws IOException {
    	boolean update=true;
		logger.info("Entrando a servicio");
		logger.info("JSON RECIBIDO POR HTTP:"+json);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ReportDto reportDto = objectMapper.readValue(json, new TypeReference<ReportDto>() {
			});
			
			
			ReportDto reportDtoGuardado = reportService.saveReport(reportDto,files);
			
			//CREAR MECANISMO PARA ENVIAR CORREO DE NOTIFICACION A AFILIADOS Y A PERSONAL RESPONSABLES DE ATENDER SOLICITUD	
	        

			return new ResponseEntity<>(reportDtoGuardado, HttpStatus.CREATED);
		} catch (Exception e) {
			
			
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        //return ResponseEntity.ok(reportService.saveReport(report, files));
    }
    
    @GetMapping
    public ResponseEntity<List<ReportSummaryDto>> getAllReports() {
        List<ReportSummaryDto> reports = reportService.getAllReportSummaries();
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDto> getReportById(@PathVariable Long id) {
        ReportDto report = reportService.getReportById(id);
        return ResponseEntity.ok(report);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportDto> updateReport(@PathVariable Long id, @RequestBody ReportDto reportDto) {
        ReportDto updatedReport = reportService.updateReport(id, reportDto);
        return ResponseEntity.ok(updatedReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
    
}
