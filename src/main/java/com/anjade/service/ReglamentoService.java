package com.anjade.service;


import java.util.List;

import com.anjade.entity.ReglamentosDto;

public interface ReglamentoService {
    

    public List<ReglamentosDto> getAllReglamentos();

    public ReglamentosDto saveReglamento(ReglamentosDto reglamento);

    public void deleteReglamento(Long id);

}