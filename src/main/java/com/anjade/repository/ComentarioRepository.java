package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anjade.entity.ComentarioDto;

public interface ComentarioRepository extends JpaRepository<ComentarioDto, Long> {}


