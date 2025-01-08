package com.anjade.service;

import com.anjade.entity.AyudaDto;
import java.util.List;

public interface AyudaService {
	AyudaDto saveAyuda(AyudaDto ayuda);
	AyudaDto getAyudaById(Long id);
    List<AyudaDto> getAllAyudas();
    AyudaDto updateAyuda(Long id, AyudaDto ayuda);
    void deleteAyuda(Long id);
    List<AyudaDto> getAyudasByModulo(String modulo);
}