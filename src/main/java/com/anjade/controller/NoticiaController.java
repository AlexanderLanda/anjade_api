package com.anjade.controller;


import com.anjade.entity.Noticia;
import com.anjade.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Noticia> crearNoticia(
            @RequestParam String titulo,
            @RequestParam String linkOriginal,
            @RequestParam String tipo,
            @RequestParam("imagenes") List<MultipartFile> imagenes) {
        
        Noticia noticia = new Noticia();
        noticia.setTitulo(titulo);
        noticia.setLinkOriginal(linkOriginal);
        noticia.setTipo(Noticia.TipoNoticia.valueOf(tipo));
        
        return ResponseEntity.ok(noticiaService.crearNoticia(noticia, imagenes));
    }

    @GetMapping
    public ResponseEntity<Page<Noticia>> obtenerNoticias(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanio,
            @RequestParam(required = false) Noticia.TipoNoticia tipo) {
        return ResponseEntity.ok(noticiaService.obtenerNoticias(pagina, tamanio, tipo));
    }
}

class NoticiaRequest {
    private String titulo;
    private String linkOriginal;
    private String tipo;
    private List<String> imagenes;
    
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getLinkOriginal() {
		return linkOriginal;
	}
	public void setLinkOriginal(String linkOriginal) {
		this.linkOriginal = linkOriginal;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<String> getImagenes() {
		return imagenes;
	}
	public void setImagenes(List<String> imagenes) {
		this.imagenes = imagenes;
	}

    // Getters y setters
}
	
