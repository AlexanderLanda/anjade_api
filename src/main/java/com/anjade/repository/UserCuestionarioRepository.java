package com.anjade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anjade.entity.UserCuestionarioDto;
import com.anjade.entity.UsuariosDto;

@Repository
public interface UserCuestionarioRepository extends JpaRepository<UserCuestionarioDto, Long> {
    
	boolean existsByUsuario(UsuariosDto userId);
    
    Optional<UserCuestionarioDto> findByUsuario(UsuariosDto userId);
    
    List<UserCuestionarioDto> findAllByUsuario(UsuariosDto userId);
    
   
    
}