package com.anjade.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.AttachmentDto;

@Repository
public interface AttachmentRepository extends JpaRepository<AttachmentDto, Long> {

	List<AttachmentDto> findByReportId(Long reportId);
	
	void deleteByReportId(Long reportId);
	
}
