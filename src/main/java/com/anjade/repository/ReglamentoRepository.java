package com.anjade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.ReglamentosDto;

@Repository
public interface ReglamentoRepository extends JpaRepository<ReglamentosDto, Long> {
	
	
	    List<ReglamentosDto> findByDeporte(String deporte);
	    
	    List<ReglamentosDto> findAll();
	


}
