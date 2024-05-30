package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjade.entity.CuestionarioDto;
import com.anjade.exception.AfiliadosCategoriasNotFoundException;
import com.anjade.repository.CuestionarioRepository;
import com.anjade.service.CuestionarioService;

@Service
public class CuestionarioServiceImpl implements CuestionarioService {

	private final CuestionarioRepository cuestionarioRepository;
	
	public CuestionarioServiceImpl(CuestionarioRepository cuestionarioRepository) {
		this.cuestionarioRepository =  cuestionarioRepository;
	}
	
	@Override
	public List<CuestionarioDto> getAllCuestionarios() {
		// TODO Auto-generated method stub
		return cuestionarioRepository.findAll();
	}

	@Override
	public CuestionarioDto getCuestionarioById(Long id) {
		CuestionarioDto cuestionario = cuestionarioRepository.findById(id).orElseThrow(() -> new AfiliadosCategoriasNotFoundException("Cuestionario no encontrado"));
	    return cuestionario;
	}

	@Override
	public void saveOrUpdate(CuestionarioDto rol) {
		// TODO Auto-generated method stub
		cuestionarioRepository.save(rol);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cuestionarioRepository.deleteById(id);
	}

}
