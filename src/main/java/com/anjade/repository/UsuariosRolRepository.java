package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.UsuariosRolDto;

@Repository
public interface UsuariosRolRepository extends JpaRepository<UsuariosRolDto, Long>{

}
