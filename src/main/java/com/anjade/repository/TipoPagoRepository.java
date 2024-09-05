package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.TipoPagoDto;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPagoDto, Long> {

}
