package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anjade.entity.ProvinciaDto;
import com.anjade.exception.LocalidadesNotFoundException;
import com.anjade.repository.ProvinciaRepository;
import com.anjade.service.ProvinciaService;

@Service
public class ProvinciasServiceImpl implements ProvinciaService{

	private final ProvinciaRepository provinciaRepository;
	
	public ProvinciasServiceImpl(ProvinciaRepository provinciaRepository) {
		super();
		this.provinciaRepository = provinciaRepository;
	}

	@Override
	public List<ProvinciaDto> getAllProvincias() {
		// TODO Auto-generated method stub
		return provinciaRepository.findAll();
	}

	@Override
	public ProvinciaDto getProvinciasById(Long id) {
		// TODO Auto-generated method stub
		ProvinciaDto provincia = provinciaRepository.findById(id).orElseThrow(() -> new LocalidadesNotFoundException("Provincia no encontrado"));
		return provincia;
	}

	@Override
	public void saveOrUpdate(ProvinciaDto provincia) {
		// TODO Auto-generated method stub
		provinciaRepository.save(provincia);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		provinciaRepository.deleteById(id);
		
	}

}
