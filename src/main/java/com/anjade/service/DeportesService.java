package com.anjade.service;

import java.util.List;

import com.anjade.entity.DeportesDto;


public interface DeportesService {

	List<DeportesDto> getAllDeportes();
	
	DeportesDto getDeportesById(Long id);
	
	DeportesDto saveOrUpdate(DeportesDto deporte);
	
	void delete(Long id);
}
