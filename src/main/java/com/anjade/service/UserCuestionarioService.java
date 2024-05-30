package com.anjade.service;

import java.util.List;

import com.anjade.entity.UserCuestionarioDto;


public interface UserCuestionarioService {
	
	
	List<UserCuestionarioDto> getAllUserCuestionarios();
	
	UserCuestionarioDto getUserCuestionarioById(Long id);
	
	void saveOrUpdate(UserCuestionarioDto rol);
	
	void delete(Long id);
	

}
