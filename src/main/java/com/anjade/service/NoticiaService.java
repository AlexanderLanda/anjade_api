package com.anjade.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.anjade.entity.Noticia;
import com.anjade.entity.NoticiaDTO;

public interface NoticiaService {

	Noticia crearNoticia(NoticiaDTO noticiaDTO);
	
	Page<Noticia> obtenerNoticias(int pagina, int tamanio, String tipo);
}
