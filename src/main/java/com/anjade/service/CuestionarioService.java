package com.anjade.service;

import java.util.List;

import com.anjade.entity.CuestionarioDto;


public interface CuestionarioService {

	List<CuestionarioDto> getAllCuestionarios();

	CuestionarioDto getCuestionarioById(Long id);

	void saveOrUpdate(CuestionarioDto rol);

	void delete(Long id);
}
