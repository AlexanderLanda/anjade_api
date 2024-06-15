package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.UsuariosDto;
import java.util.List;
import java.util.Optional;


@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosDto, Long>{
	
	UsuariosDto findByIdAfiliacion(String idAfiliacion);
	
    Optional<UsuariosDto> findByCorreo(String correo);


}
