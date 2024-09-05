package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anjade.entity.LocalidadDto;
import com.anjade.exception.LocalidadesNotFoundException;
import com.anjade.repository.LocalidadRepository;
import com.anjade.service.LocalidadService;

@Service
public class LocalidadesServiceImpl implements LocalidadService{
	
	private final LocalidadRepository localidadRepository ;
	
	

	public LocalidadesServiceImpl(LocalidadRepository localidadRepository) {
		super();
		this.localidadRepository = localidadRepository;
	}

	@Override
	public List<LocalidadDto> getAllLocalidades() {
		// TODO Auto-generated method stub
		return localidadRepository.findAll();
	}

	@Override
	public LocalidadDto getLocalidadById(Long id) {
		// TODO Auto-generated method stub
		LocalidadDto localidad = localidadRepository.findById(id).orElseThrow(() -> new LocalidadesNotFoundException("Localidad no encontrado"));
		return localidad;
	}

	@Override
	public void saveOrUpdate(LocalidadDto localidad) {
		localidadRepository.save(localidad);
	}

	@Override
	public void delete(Long id) {
		localidadRepository.deleteById(id);
		
	}

}
