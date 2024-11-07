package com.anjade.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.anjade.entity.Noticia;

public interface NoticiaService {

	Noticia crearNoticia(Noticia noticia, List<String> urlsImagenes);
	
	Page<Noticia> obtenerNoticias(int pagina, int tamanio, Noticia.TipoNoticia tipo);
}
