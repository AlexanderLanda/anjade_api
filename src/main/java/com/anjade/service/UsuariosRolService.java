package com.anjade.service;

import java.util.List;

import com.anjade.entity.UsuariosRolDto;


public interface UsuariosRolService {

	List<UsuariosRolDto> getAllRolesUsuarios();
	
	UsuariosRolDto getRolesUsuariosById(Long id);
	
	void saveOrUpdate(UsuariosRolDto rol);
	
	void delete(Long id);
}
