package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.EstadosUsuariosDto;

@Repository
public interface EstadosUsuariosRepository extends JpaRepository<EstadosUsuariosDto, Long>{

}
