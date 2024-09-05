package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.ProvinciaDto;

@Repository
public interface ProvinciaRepository extends JpaRepository<ProvinciaDto, Long> {

}
