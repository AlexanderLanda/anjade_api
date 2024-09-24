package com.anjade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.ReportDto;
import com.anjade.entity.ReportSummaryDto;

@Repository
public interface ReportRepository extends JpaRepository<ReportDto, Long>{
    
	List<ReportSummaryDto> findAllProjectedBy();


}
