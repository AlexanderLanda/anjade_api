package com.anjade.controller;


import com.anjade.entity.Noticia;
import com.anjade.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/noticias")
public class NoticiaController {

	@Autowired
    private NoticiaService noticiaService;

    @PostMapping
    public ResponseEntity<Noticia> crearNoticia(@RequestBody NoticiaRequest noticiaRequest) {
        Noticia noticia = new Noticia();
        noticia.setTitulo(noticiaRequest.getTitulo());
        noticia.setLinkOriginal(noticiaRequest.getLinkOriginal());
        noticia.setTipo(noticiaRequest.getTipo());
        return ResponseEntity.ok(noticiaService.crearNoticia(noticia, noticiaRequest.getUrlsImagenes()));
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
    private Noticia.TipoNoticia tipo;
    private List<String> urlsImagenes;
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
	public Noticia.TipoNoticia getTipo() {
		return tipo;
	}
	public void setTipo(Noticia.TipoNoticia tipo) {
		this.tipo = tipo;
	}
	public List<String> getUrlsImagenes() {
		return urlsImagenes;
	}
	public void setUrlsImagenes(List<String> urlsImagenes) {
		this.urlsImagenes = urlsImagenes;
	}

    // Getters y setters
}
	
