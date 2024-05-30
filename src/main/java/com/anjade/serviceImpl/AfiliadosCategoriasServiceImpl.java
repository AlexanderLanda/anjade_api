package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anjade.entity.AfiliadosCategoriasDto;
import com.anjade.entity.AfiliadosFuncionDto;
import com.anjade.exception.AfiliadosCategoriasNotFoundException;
import com.anjade.repository.AfiliadosCategoriaRepository;
import com.anjade.repository.AfiliadosFuncionRepository;
import com.anjade.service.AfiliadosCategoriaService;
import com.anjade.service.AfiliadosFuncionService;

@Service
public class AfiliadosCategoriasServiceImpl implements AfiliadosCategoriaService {


	private final AfiliadosCategoriaRepository afiliadosCategoriaRepository;

    public AfiliadosCategoriasServiceImpl(AfiliadosCategoriaRepository afiliadosCategoriaRepository) {
        this.afiliadosCategoriaRepository = afiliadosCategoriaRepository;
    }
	
	
	@Override
	public List<AfiliadosCategoriasDto> getAllCategoriasAfiliados() {
		// TODO Auto-generated method stub
		return afiliadosCategoriaRepository.findAll();
	}

	@Override
	public AfiliadosCategoriasDto getCategoriasAfiliadosById(Long id) {
		 
		AfiliadosCategoriasDto afiliadosCategoria = afiliadosCategoriaRepository.findById(id).orElseThrow(() -> new AfiliadosCategoriasNotFoundException("AfiliadosRol no encontrado"));
	    return afiliadosCategoria;
	}

	@Override
	public void saveOrUpdate(AfiliadosCategoriasDto rol) {

		afiliadosCategoriaRepository.save(rol);		
	}

	@Override
	public void delete(Long rol) {
		afiliadosCategoriaRepository.deleteById(rol);
		
	}

}
