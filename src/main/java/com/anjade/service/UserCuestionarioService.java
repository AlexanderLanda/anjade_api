package com.anjade.service;

import java.util.List;

import com.anjade.entity.CuestionarioRespuestaDto;
import com.anjade.entity.UserCuestionarioDto;


public interface UserCuestionarioService {
	
	
	List<UserCuestionarioDto> getAllUserCuestionarios();
	
	 List<CuestionarioRespuestaDto> getCuestionarioByUserId(Long id);
	
	void saveOrUpdate(UserCuestionarioDto rol);
	
	void delete(Long id);
	
	
	 boolean existsCuestionarioForUser(Long userId) ;

	
}
