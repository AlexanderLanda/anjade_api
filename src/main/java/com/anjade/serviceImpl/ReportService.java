package com.anjade.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.anjade.entity.AttachmentDto;
import com.anjade.entity.ReportDto;
import com.anjade.repository.AttachmentRepository;
import com.anjade.repository.ReportRepository;

import java.io.IOException;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;

    @Transactional
    public ReportDto saveReport(ReportDto report, List<MultipartFile> files) throws IOException {
        report = reportRepository.save(report);

        for (MultipartFile file : files) {
            AttachmentDto attachment = new AttachmentDto();
            attachment.setFileName(file.getOriginalFilename());
            attachment.setFileType(file.getContentType());
            attachment.setData(file.getBytes());
            attachment.setReport(report);
            attachmentRepository.save(attachment);
        }

        return report;
    }
}
