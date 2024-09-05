package com.anjade.service;

import java.util.List;

import com.anjade.entity.AfiliadosCategoriasDto;
import com.anjade.entity.AfiliadosFuncionDto;

public interface AfiliadosCategoriaService {

		List<AfiliadosCategoriasDto> getAllCategoriasAfiliados();
		
		AfiliadosCategoriasDto getCategoriasAfiliadosById(Long id);
		
		void saveOrUpdate(AfiliadosCategoriasDto rol);
		
		void delete(Long id);
		
		
}
