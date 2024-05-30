package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anjade.entity.AfiliadosFuncionDto;
import com.anjade.exception.AfiliadosCategoriasNotFoundException;
import com.anjade.repository.AfiliadosFuncionRepository;
import com.anjade.service.AfiliadosFuncionService;

@Service
public class AfiliadosFuncionServiceImpl implements AfiliadosFuncionService {


	private final AfiliadosFuncionRepository afiliadosRolRepository;

    public AfiliadosFuncionServiceImpl(AfiliadosFuncionRepository afiliadosRolRepository) {
        this.afiliadosRolRepository = afiliadosRolRepository;
    }
	
	
	@Override
	public List<AfiliadosFuncionDto> getAllFunctionAfiliados() {
		// TODO Auto-generated method stub
		return afiliadosRolRepository.findAll();
	}

	@Override
	public AfiliadosFuncionDto getFunctionAfiliadosById(Long id) {
		 
		AfiliadosFuncionDto afiliadosRol = afiliadosRolRepository.findById(id).orElseThrow(() -> new AfiliadosCategoriasNotFoundException("AfiliadosRol no encontrado"));
	    return afiliadosRol;
	}

	@Override
	public void saveOrUpdate(AfiliadosFuncionDto rol) {

		afiliadosRolRepository.save(rol);		
	}

	@Override
	public void delete(Long rol) {
		afiliadosRolRepository.deleteById(rol);
		
	}

}
