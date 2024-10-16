package com.anjade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.anjade.entity.AttachmentDto;
import com.anjade.service.AttachmentService;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attachments")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @GetMapping("/report/{reportId}")
    public ResponseEntity<List<AttachmentDto>> getAttachmentsByReportId(@PathVariable Long reportId) {
        List<AttachmentDto> attachments = attachmentService.getAttachmentsByReportId(reportId);
        return ResponseEntity.ok(attachments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> downloadAttachment(@PathVariable Long id) {
        AttachmentDto attachment = attachmentService.getAttachmentById(id);
        ByteArrayResource resource = new ByteArrayResource(attachment.getData());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachment.getFileName() + "\"")
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .body(resource);
    }
}