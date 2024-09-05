package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.ReportDto;

@Repository
public interface ReportRepository extends JpaRepository<ReportDto, Long>{

}
