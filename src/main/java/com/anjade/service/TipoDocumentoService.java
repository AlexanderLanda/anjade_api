package com.anjade.service;

import java.util.List;

import com.anjade.entity.TipoDocumentoDto;


public interface TipoDocumentoService {

	List<TipoDocumentoDto> getAllTipoDocumentoDto();

	TipoDocumentoDto getTipoDocumentoById(Long id);

}
