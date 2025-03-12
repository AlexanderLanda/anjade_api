	package com.anjade.serviceImpl;

import org.springframework.stereotype.Service;

import com.anjade.entity.ReglamentosDto;
import com.anjade.repository.ReglamentoRepository;
import com.anjade.service.ReglamentoService;
import java.util.List;


@Service	
public class ReglamentoServiceImpl implements ReglamentoService{

    private final ReglamentoRepository repository;

    
    public ReglamentoServiceImpl(ReglamentoRepository repository) {
        this.repository = repository;
    }

	@Override
    public List<ReglamentosDto> getAllReglamentos() {
        return repository.findAll();
    }

	@Override
    public ReglamentosDto saveReglamento(ReglamentosDto reglamento) {
        return repository.save(reglamento);
    }

	@Override
    public void deleteReglamento(Long id) {
        repository.deleteById(id);
    }

}


