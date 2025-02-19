package com.anjade.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.anjade.entity.AttachmentDto;
import com.anjade.entity.ReportDto;
import com.anjade.entity.ReportSummaryDto;
import com.anjade.exception.UsuariosRolNotFoundException;
import com.anjade.repository.AttachmentRepository;
import com.anjade.repository.ReportRepository;
import com.anjade.service.ReportService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.anjade.exception.ResourceNotFoundException;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;

    @Transactional
    public ReportDto saveReport(ReportDto report, List<MultipartFile> files) throws IOException {

    	LocalDateTime ahora = LocalDateTime.now();
    	Date fechaActual = Date.from(ahora.atZone(ZoneId.systemDefault()).toInstant());
    	List<AttachmentDto> attachments = new ArrayList<AttachmentDto>();
    	for (MultipartFile file : files) { 
        	AttachmentDto attachment = new AttachmentDto();
            attachment.setFileName(file.getOriginalFilename());
            attachment.setFileType(file.getContentType());
            attachment.setData(file.getBytes());
            attachment.setReport(report);
            attachment.setCreatedAt(fechaActual);
            attachments.add(attachment);
            //attachmentRepository.save(attachment);
        }
    	report.setCreateDate(fechaActual);
    	report.setAttachments(attachments);
    	report = reportRepository.save(report);

       

        return report;
    }
    
	@Override
    public List<ReportSummaryDto> getAllReportSummaries() {
        return reportRepository.findAllProjectedBy();
    }

	@Override
	public List<ReportDto> getAllReports() {
		// TODO Auto-generated method stub
		return reportRepository.findAll();
	}

	@Override
	public ReportDto getReportById(Long id) {
		// TODO Auto-generated method stub
		
		ReportDto report = reportRepository.findById(id).orElseThrow(() -> new UsuariosRolNotFoundException("Reporte no encontrado"));
		return report;
	}
	
	@Transactional
	public ReportDto updateReport(ReportDto reportDto) {
	    ReportDto existingReport = reportRepository.findById(reportDto.getId())
	            .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));

	    // Actualizar los campos básicos
	    existingReport.setDescripcion(reportDto.getDescripcion());

	    // Manejo de archivos adjuntos
	    updateAttachments(existingReport, reportDto.getAttachments());

	    // Guardar el reporte actualizado
	    ReportDto updatedReport = reportRepository.save(existingReport);
	    
	    return updatedReport;
	}

	/**
	 * Método para actualizar la lista de archivos adjuntos
	 */
	private void updateAttachments(ReportDto existingReport, List<AttachmentDto> newAttachments) {
	    // Si no hay adjuntos nuevos, eliminamos todos los existentes
	    if (newAttachments == null || newAttachments.isEmpty()) {
	        existingReport.getAttachments().clear();
	    } else {
	        // Eliminar archivos que el usuario quitó
	        existingReport.getAttachments().removeIf(existingFile -> 
	            newAttachments.stream().noneMatch(newFile -> newFile.getFileName().equals(existingFile.getFileName()))
	        );

	        // Agregar nuevos archivos
	        for (AttachmentDto newFile : newAttachments) {
	            if (existingReport.getAttachments().stream().noneMatch(f -> f.getFileName().equals(newFile.getFileName()))) {
	                existingReport.getAttachments().add(newFile);
	            }
	        }
	    }
	}


    @Transactional
    public void deleteReport(Long id) {
    	ReportDto report = reportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found with id: " + id));

        // Primero, eliminar todos los attachments asociados
        attachmentRepository.deleteByReportId(id);

        // Luego, eliminar el reporte
        reportRepository.delete(report);
    }
}
