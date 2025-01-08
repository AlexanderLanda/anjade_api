package com.anjade.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjade.entity.AyudaDto;
import com.anjade.repository.AyudaRepository;
import com.anjade.service.AyudaService;

@Service
public class AyudaServiceImpl implements AyudaService {

    @Autowired
    private AyudaRepository ayudaRepository;

    @Override
    public AyudaDto saveAyuda(AyudaDto ayuda) {
        return ayudaRepository.save(ayuda);
    }

    @Override
    public AyudaDto getAyudaById(Long id) {
        return ayudaRepository.findById(id).orElse(null);
    }

    @Override
    public List<AyudaDto> getAllAyudas() {
        return ayudaRepository.findAll();
    }

    @Override
    public AyudaDto updateAyuda(Long id, AyudaDto ayuda) {
        Optional<AyudaDto> optionalAyuda = ayudaRepository.findById(id);
        if (optionalAyuda.isPresent()) {
        	AyudaDto existingAyuda = optionalAyuda.get();
            existingAyuda.setPregunta(ayuda.getPregunta());
            existingAyuda.setRespuesta(ayuda.getRespuesta());
            existingAyuda.setModulo(ayuda.getModulo());
            return ayudaRepository.save(existingAyuda);
        }
        return null;
    }

    @Override
    public void deleteAyuda(Long id) {
        ayudaRepository.deleteById(id);
    }
    
    @Override
    public List<AyudaDto> getAyudasByModulo(String modulo) {
        return ayudaRepository.findByModulo(modulo); // Llamada al método del repositorio
    }
}