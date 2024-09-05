package com.anjade.service;

import java.util.List;

import com.anjade.entity.FederacionDto;


public interface FederacionService {

	List<FederacionDto> getAllFederaciones();

	FederacionDto getFederacionById(Long id);

	void saveOrUpdate(FederacionDto rol);

	void delete(Long id);

}
