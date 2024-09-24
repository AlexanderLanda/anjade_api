package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjade.entity.AttachmentDto;
import com.anjade.entity.ReportDto;
import com.anjade.exception.UsuariosRolNotFoundException;
import com.anjade.repository.AttachmentRepository;
import com.anjade.service.AttachmentService;

@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	private AttachmentRepository attachmentRepository;
	
	@Override
	public List<AttachmentDto> getAttachmentsByReportId(Long reportId) {
		// TODO Auto-generated method stub
		return attachmentRepository.findByReportId(reportId);
	}
	
	@Override
	public AttachmentDto getAttachmentById(Long id) {
		// TODO Auto-generated method stub
		
		AttachmentDto attachment = attachmentRepository.findById(id).orElseThrow(() -> new UsuariosRolNotFoundException("Archivo no encontrado"));
		return attachment;
	}
	

}
