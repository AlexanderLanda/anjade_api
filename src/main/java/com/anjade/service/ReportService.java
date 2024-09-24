package com.anjade.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.anjade.entity.ReportDto;
import com.anjade.entity.ReportSummaryDto;

public interface ReportService {

	ReportDto saveReport(ReportDto report, List<MultipartFile> files) throws IOException;
	
	List<ReportDto> getAllReports();
	
	ReportDto getReportById(Long id);

	List<ReportSummaryDto> getAllReportSummaries();
	
	
}
