package com.anjade.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anjade.entity.DsOrderIdAfiliacionDto;

@Repository
public interface DsOrderIdAfiliacionRepository  extends JpaRepository<DsOrderIdAfiliacionDto, Long> {

	 Optional<DsOrderIdAfiliacionDto>  findByIdAfiliacion(String idAfiliacion);
	
	 @Query("SELECT MAX(CAST(d.dsOrder  AS int)) FROM DsOrderIdAfiliacionDto d")
	    Integer findMaxDsOrder();
	 
	 
	 
	 DsOrderIdAfiliacionDto  findByDsOrder(String ds_order);
}
