package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.DeportesDto;

@Repository
public interface DeportesRepository extends JpaRepository<DeportesDto, Long>{

}
