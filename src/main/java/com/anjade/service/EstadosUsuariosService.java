package com.anjade.service;

import java.util.List;

import com.anjade.entity.EstadosUsuariosDto;


public interface EstadosUsuariosService {

	List<EstadosUsuariosDto> getAllEstadosUsuarios();
	
	EstadosUsuariosDto getEstadosUsuariosById(Long id);
	
	void saveOrUpdate(EstadosUsuariosDto estado);
	
	void delete(Long id);
}
