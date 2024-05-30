package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anjade.entity.FederacionDto;
import com.anjade.exception.FederacionNotFoundException;
import com.anjade.repository.FederacionRepository;
import com.anjade.service.FederacionService;


@Service
public class FederacionServiceImpl implements FederacionService{

	private final FederacionRepository federacionRepository;
	
	
	
	
	public FederacionServiceImpl(FederacionRepository federacionRepository) {
		super();
		this.federacionRepository = federacionRepository;
	}

	@Override
	public List<FederacionDto> getAllFederaciones() {
		// TODO Auto-generated method stub
		return federacionRepository.findAll();
	}

	@Override
	public FederacionDto getFederacionById(Long id) {
		// TODO Auto-generated method stub
		FederacionDto federacionDto = federacionRepository.findById(id).orElseThrow(() -> new FederacionNotFoundException("Federacion no encontrado"));
	    return federacionDto;
	}

	@Override
	public void saveOrUpdate(FederacionDto federacion) {
		// TODO Auto-generated method stub
		federacionRepository.save(federacion);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		federacionRepository.deleteById(id);
	}

}
