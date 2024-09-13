package com.anjade.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjade.entity.DsOrderIdAfiliacionDto;
import com.anjade.repository.DsOrderIdAfiliacionRepository;
import com.anjade.service.DsOrderIdAfiliacionService;

@Service
public class DsOrderIdAfiliacionServiceImpl implements DsOrderIdAfiliacionService {

	@Autowired
	private DsOrderIdAfiliacionRepository repository;


	@Override
	public Integer getMaxDsOrder() {
		 Integer maxDsOrder = repository.findMaxDsOrder();
	        return maxDsOrder != null ? maxDsOrder : 0;
	}

	@Override
	public String generateNextDsOrder() {
		 Integer maxDsOrder = getMaxDsOrder();
	        return String.format("%06d", maxDsOrder + 1);
	}
	
	@Override
	public DsOrderIdAfiliacionDto saveOrUpdate(DsOrderIdAfiliacionDto order) {
		
		return repository.save(order);
	}

	@Override
	public DsOrderIdAfiliacionDto findByIdAfiliacion(String idAfiliacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
