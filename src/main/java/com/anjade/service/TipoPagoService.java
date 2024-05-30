package com.anjade.service;

import java.util.List;

import com.anjade.entity.TipoPagoDto;


public interface TipoPagoService {

	List<TipoPagoDto> getAllTiposPagos();

	TipoPagoDto getTipoPagosById(Long id);

}
