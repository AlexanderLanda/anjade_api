package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjade.entity.AfiliadosFuncionDto;
import com.anjade.entity.DeportesDto;
import com.anjade.exception.AfiliadosCategoriasNotFoundException;
import com.anjade.exception.DeportesNotFoundException;
import com.anjade.repository.AfiliadosFuncionRepository;
import com.anjade.repository.DeportesRepository;
import com.anjade.service.AfiliadosFuncionService;
import com.anjade.service.DeportesService;

@Service
public class DeportesServiceImpl implements DeportesService {

	@Autowired
	private final DeportesRepository deportesRepository;

    public DeportesServiceImpl(DeportesRepository deportesRepository) {
        this.deportesRepository = deportesRepository;
    }
	
	
	@Override
	public List<DeportesDto> getAllDeportes() {
		// TODO Auto-generated method stub
		return deportesRepository.findAll();
	}

	@Override
	public DeportesDto getDeportesById(Long id) {
		 
		DeportesDto deporte = deportesRepository.findById(id).orElseThrow(() -> new DeportesNotFoundException("Deporte no encontrado"));
	    return deporte;
	}

	@Override
	public DeportesDto saveOrUpdate(DeportesDto deporte) {

		return deportesRepository.save(deporte);		
	}
	
	

	@Override
	public void delete(Long deporte) {
		deportesRepository.deleteById(deporte);
		
	}

}
