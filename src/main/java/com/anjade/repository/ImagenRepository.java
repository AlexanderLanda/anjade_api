package com.anjade.repository;

import com.anjade.entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long> {
    
    // Este método encuentra todas las imágenes asociadas a una noticia específica
    List<Imagen> findByNoticiaId(Long noticiaId);

    // Este método encuentra todas las imágenes que aún tienen contenido temporal
    List<Imagen> findByContenidoTemporalIsNotNull();

    // Si necesitas más métodos personalizados, puedes agregarlos aquí
}