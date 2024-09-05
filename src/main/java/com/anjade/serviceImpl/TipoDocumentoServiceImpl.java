package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anjade.entity.TipoDocumentoDto;
import com.anjade.exception.AfiliadosCategoriasNotFoundException;
import com.anjade.repository.TipoDocumentoRepository;
import com.anjade.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	private TipoDocumentoRepository tipoDocumentoRepository;
	
	
	
	public TipoDocumentoServiceImpl(TipoDocumentoRepository tipoDocumento) {
		super();
		this.tipoDocumentoRepository = tipoDocumento;
	}

	@Override
	public List<TipoDocumentoDto> getAllTipoDocumentoDto() {
		// TODO Auto-generated method stub
		return tipoDocumentoRepository.findAll();
	}

	@Override
	public TipoDocumentoDto getTipoDocumentoById(Long id) {
		// TODO Auto-generated method stub
		return tipoDocumentoRepository.findById(id).orElseThrow(() -> new AfiliadosCategoriasNotFoundException("Tipo de Documentacion no encontrada"));
	}

}
