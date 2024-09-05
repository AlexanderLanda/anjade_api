package com.anjade.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.anjade.entity.ReportDto;
import com.anjade.serviceImpl.ReportService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<ReportDto> createReport(
            @RequestParam("afiliacionId") String afiliacionId,
            @RequestParam("nombre") String nombre,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("files") List<MultipartFile> files) throws IOException {

        ReportDto report = new ReportDto();
        report.setAfiliacionId(afiliacionId);
        report.setNombre(nombre);
        report.setApellidos(apellidos);
        report.setDescripcion(descripcion);

        return ResponseEntity.ok(reportService.saveReport(report, files));
    }
}
