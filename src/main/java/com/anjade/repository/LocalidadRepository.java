package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.LocalidadDto;

@Repository
public interface LocalidadRepository extends JpaRepository<LocalidadDto, Long> {

}
