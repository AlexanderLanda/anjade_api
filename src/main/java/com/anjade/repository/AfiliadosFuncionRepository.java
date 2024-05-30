package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.AfiliadosFuncionDto;

@Repository
public interface AfiliadosFuncionRepository extends JpaRepository<AfiliadosFuncionDto, Long> {

}
