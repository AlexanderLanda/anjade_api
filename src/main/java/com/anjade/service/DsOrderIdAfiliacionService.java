package com.anjade.service;

import com.anjade.entity.DsOrderIdAfiliacionDto;

public interface DsOrderIdAfiliacionService {
	
	DsOrderIdAfiliacionDto findByIdAfiliacion(String idAfiliacion);
	
	Integer getMaxDsOrder();
	
	String generateNextDsOrder();
	
	 DsOrderIdAfiliacionDto saveOrUpdate(DsOrderIdAfiliacionDto order);

}