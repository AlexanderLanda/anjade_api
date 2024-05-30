package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.CuestionarioDto;

@Repository
public interface CuestionarioRepository extends JpaRepository<CuestionarioDto, Long> {

}
