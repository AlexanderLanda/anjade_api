package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anjade.entity.TipoPagoDto;
import com.anjade.exception.AfiliadosCategoriasNotFoundException;
import com.anjade.repository.TipoPagoRepository;
import com.anjade.service.TipoPagoService;

@Service
public class TipoPagoServiceImpl implements TipoPagoService{

	private TipoPagoRepository tipoPagoRepository;
	
	
	
	public TipoPagoServiceImpl(TipoPagoRepository tipoPagoRepository) {
		super();
		this.tipoPagoRepository = tipoPagoRepository;
	}

	@Override
	public List<TipoPagoDto> getAllTiposPagos() {
		// TODO Auto-generated method stub
		return tipoPagoRepository.findAll();
	}

	@Override
	public TipoPagoDto getTipoPagosById(Long id) {
		// TODO Auto-generated method stub
		TipoPagoDto tipo = tipoPagoRepository.findById(id).orElseThrow(() -> new AfiliadosCategoriasNotFoundException("Forma de pago no encontrado"));
		return tipo;
	}

}
