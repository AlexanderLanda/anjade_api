package com.anjade.service;

import java.util.List;

import com.anjade.entity.AttachmentDto;

public interface AttachmentService {

	List<AttachmentDto> getAttachmentsByReportId(Long reportId);

	AttachmentDto getAttachmentById(Long id);
	
	
	
}
