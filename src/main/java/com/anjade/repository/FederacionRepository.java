package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.FederacionDto;

@Repository
public interface FederacionRepository extends JpaRepository<FederacionDto, Long>{

}
