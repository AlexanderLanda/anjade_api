package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anjade.entity.AfiliadosFuncionDto;
import com.anjade.entity.DeportesDto;
import com.anjade.entity.EstadosUsuariosDto;
import com.anjade.exception.AfiliadosCategoriasNotFoundException;
import com.anjade.exception.DeportesNotFoundException;
import com.anjade.exception.EstadosUsuariosNotFoundException;
import com.anjade.repository.AfiliadosFuncionRepository;
import com.anjade.repository.DeportesRepository;
import com.anjade.repository.EstadosUsuariosRepository;
import com.anjade.service.AfiliadosFuncionService;
import com.anjade.service.DeportesService;
import com.anjade.service.EstadosUsuariosService;

@Service
public class EstadosUsuariosServiceImpl implements EstadosUsuariosService {


	private final EstadosUsuariosRepository estadosUsuariosRepository;

    public EstadosUsuariosServiceImpl(EstadosUsuariosRepository estadosUsuariosRepository) {
        this.estadosUsuariosRepository = estadosUsuariosRepository;
    }
	
	
	@Override
	public List<EstadosUsuariosDto> getAllEstadosUsuarios() {
		// TODO Auto-generated method stub
		return estadosUsuariosRepository.findAll();
	}

	@Override
	public EstadosUsuariosDto getEstadosUsuariosById(Long id) {
		 
		EstadosUsuariosDto estado = estadosUsuariosRepository.findById(id).orElseThrow(() -> new EstadosUsuariosNotFoundException("Estado no encontrado"));
	    return estado;
	}

	@Override
	public void saveOrUpdate(EstadosUsuariosDto estado) {

		estadosUsuariosRepository.save(estado);		
	}

	@Override
	public void delete(Long estado) {
		estadosUsuariosRepository.deleteById(estado);
		
	}

}
