package com.anjade.repository;

import com.anjade.entity.Noticia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    Page<Noticia> findAllByOrderByFechaInsercionDesc(Pageable pageable);
    Page<Noticia> findByTipo(String tipo, Pageable pageable);
}