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
    public ReportDto updateReport(Long id, ReportDto reportDto) {
		ReportDto existingReport = reportRepository.findById(id)
                .orElseThrow();

        // Actualizar los campos del reporte existente
        existingReport.setAfiliacionId(reportDto.getAfiliacionId());
        existingReport.setNombre(reportDto.getNombre());
        existingReport.setApellidos(reportDto.getApellidos());
        existingReport.setDescripcion(reportDto.getDescripcion());
        existingReport.setEmail(reportDto.getEmail());
        existingReport.setTelefono(reportDto.getTelefono());

        // Guardar el reporte actualizado
        ReportDto updatedReport = reportRepository.save(existingReport);

        return updatedReport;
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
