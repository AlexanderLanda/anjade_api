package com.anjade.service;

import java.util.List;

import com.anjade.entity.LocalidadDto;

public interface LocalidadService {
	
	List<LocalidadDto> getAllLocalidades();
	
	LocalidadDto getLocalidadById(Long id);
	
	void saveOrUpdate(LocalidadDto rol);
	
	void delete(Long id);

}
