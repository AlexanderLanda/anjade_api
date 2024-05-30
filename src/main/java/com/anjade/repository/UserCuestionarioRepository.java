package com.anjade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anjade.entity.UserCuestionarioDto;

@Repository
public interface UserCuestionarioRepository extends JpaRepository<UserCuestionarioDto, Long> {

}
