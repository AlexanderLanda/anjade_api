package com.anjade.service;

import java.util.List;

import com.anjade.entity.LocalidadDto;
import com.anjade.entity.ProvinciaDto;

public interface ProvinciaService {
	
	List<ProvinciaDto> getAllProvincias();
	
	ProvinciaDto getProvinciasById(Long id);
	
	void saveOrUpdate(ProvinciaDto rol);
	
	void delete(Long id);

}
