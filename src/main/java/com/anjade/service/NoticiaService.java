package com.anjade.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.anjade.entity.Noticia;

public interface NoticiaService {

	Noticia crearNoticia(Noticia noticia, List<MultipartFile> imagenes);
	
	Page<Noticia> obtenerNoticias(int pagina, int tamanio, Noticia.TipoNoticia tipo);
}
