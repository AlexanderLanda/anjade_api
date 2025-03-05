package com.anjade.controller;


import com.anjade.entity.ComentarioDto;
import com.anjade.entity.Noticia;
import com.anjade.entity.NoticiaDTO;
import com.anjade.entity.ReportDto;
import com.anjade.repository.ComentarioRepository;
import com.anjade.repository.NoticiaRepository;
import com.anjade.service.NoticiaService;
import com.anjade.service.UsuariosService;
import com.anjade.serviceImpl.UsuariosServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;
    
    @Autowired
    private NoticiaRepository noticiaRepository;
    
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @Autowired
	private  UsuariosServiceImpl usuariosService;

    @PostMapping
    public ResponseEntity<Noticia> crearNoticia(@RequestBody NoticiaDTO noticiaDTO) {
        Noticia nuevaNoticia = noticiaService.crearNoticia(noticiaDTO);
        return ResponseEntity.ok(nuevaNoticia);
    }

    @GetMapping
    public ResponseEntity<Page<Noticia>> obtenerNoticias(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanio,
            @RequestParam(required = false) String tipo) {
        Page<Noticia> noticias = noticiaService.obtenerNoticias(pagina, tamanio, tipo);
        return ResponseEntity.ok(noticias);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Noticia>> obtenerNoticiasAll(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanio,
            @RequestParam(required = false) String tipo) {
        List<Noticia> noticias = noticiaService.getNoticias();
        return ResponseEntity.ok(noticias);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Noticia> getNoticiaById(@PathVariable Long id) {
    	Noticia noticia = noticiaService.getNoticiaById(id);
        return ResponseEntity.ok(noticia);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminarReporte(@PathVariable Long id) {
        if (!noticiaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("mensaje", "Noticia no encontrado"));
        }

        noticiaRepository.deleteById(id);
        
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Noticia eliminado correctamente");
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Noticia> actualizarNoticia(@PathVariable Long id, @RequestBody NoticiaDTO noticiaActualizada) {
        return noticiaService.actualizarNoticia(id, noticiaActualizada)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    
    /////////////////////////////////////////COMENTARIOS//
    
    @PostMapping("/{id}/comentarios")
    public ResponseEntity<ComentarioDto>  agregarComentario(@PathVariable Long id, @RequestBody ComentarioRequest comen) {
        Noticia noticia = noticiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Noticia no encontrada"));
        ComentarioDto comentario = new ComentarioDto();

        comentario.setNoticia(noticia);
        comentario.setFechaComentario(LocalDateTime.now());
        comentario.setIdAfiliacion(comen.getIdAfiliacion());
        comentario.setTexto(comen.getTexto());
        String nombreAfiliado = usuariosService.getNameByIdAfiliacion(comen.getIdAfiliacion());
        comentario.setNombre(nombreAfiliado);

        
        ComentarioDto comentarios = comentarioRepository.save(comentario);
        return ResponseEntity.ok(comentarios);
    }
    @DeleteMapping("/{id}/comentarios")
    public ResponseEntity<Map<String, String>> eliminarComentario(@PathVariable Long id) {
        if (!comentarioRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("mensaje", "Comentario no encontrado"));
        }

        comentarioRepository.deleteById(id);
        
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Comentario eliminado correctamente");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/comentarios")
    public ResponseEntity<List<ComentarioDto>>  actualizarComentario(@PathVariable Long id, @RequestBody List<ComentarioDto> comen) {
        Noticia noticia = noticiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Noticia no encontrada"));
        List<ComentarioDto> com = new ArrayList<ComentarioDto>();
        ComentarioDto comentario = new ComentarioDto();
        comentario.setNoticia(noticia);
        for(ComentarioDto c : comen) {
        	comentario.setId(c.getId());
	        comentario.setFechaComentario(c.getFechaComentario());
            comentario.setIdAfiliacion(c.getIdAfiliacion());
            comentario.setTexto(c.getTexto());
            String nombreAfiliado = usuariosService.getNameByIdAfiliacion(c.getIdAfiliacion());
            comentario.setNombre(nombreAfiliado);
            ComentarioDto comentarios = comentarioRepository.save(comentario);
            com.add(comentario);

        }
        
                return ResponseEntity.ok(com);
    }

    
    @GetMapping("/{id}/comentarios")
    public ResponseEntity<List<ComentarioDto>> obtenerComentarios(@PathVariable Long id) {
        Noticia noticia = noticiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Noticia no encontrada"));

        List<ComentarioDto> noticias = noticia.getComentarios();
        // Recorremos la lista de comentarios y actualizamos el campo "nombre"
        for (ComentarioDto comentario : noticias) {
            String idAfiliacion = comentario.getIdAfiliacion();
           // String nombreAfiliado = usuariosService.getNameByIdAfiliacion(idAfiliacion);
            //System.out.println(nombreAfiliado);// Llamamos al servicio de usuarios
           // comentario.setNombre(nombreAfiliado); // Actualizamos el campo nombre del comentario
        }
        return ResponseEntity.ok(noticias);
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

class ComentarioRequest {
	
	private String texto;
    private String idAfiliacion;
    
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getIdAfiliacion() {
		return idAfiliacion;
	}
	public void setIdAfiliacion(String idAfiliacion) {
		this.idAfiliacion = idAfiliacion;
	}
    
    
}
