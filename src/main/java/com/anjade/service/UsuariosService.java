package com.anjade.service;

import java.util.List;
import java.util.Optional;

import com.anjade.entity.UsuariosDto;


public interface UsuariosService {

	List<UsuariosDto> getAllUsuarios();
	
	UsuariosDto getUsuariosById(Long id);
	
	UsuariosDto saveOrUpdate(UsuariosDto user);
	
	void delete(UsuariosDto id);

	void deleteById(Long rol);
	
	UsuariosDto getByIdAfiliacion(String id);

	Optional<UsuariosDto> login(String idAfiliacion, String password);
}
