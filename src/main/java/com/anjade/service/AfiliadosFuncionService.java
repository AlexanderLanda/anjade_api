package com.anjade.service;

import java.util.List;

import com.anjade.entity.AfiliadosFuncionDto;

public interface AfiliadosFuncionService {

		List<AfiliadosFuncionDto> getAllFunctionAfiliados();
		
		AfiliadosFuncionDto getFunctionAfiliadosById(Long id);
		
		void saveOrUpdate(AfiliadosFuncionDto rol);
		
		void delete(Long id);
		
		
}
