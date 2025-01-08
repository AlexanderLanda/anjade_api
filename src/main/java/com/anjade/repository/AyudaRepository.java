package com.anjade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anjade.entity.AyudaDto;

public interface AyudaRepository extends JpaRepository<AyudaDto, Long>{
	List<AyudaDto> findByModulo(String modulo);
}
