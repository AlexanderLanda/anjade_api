package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.TipoDocumentoDto;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoDto, Long> {

}
