package com.anjade.serviceImpl;

import com.anjade.entity.Noticia;
import com.anjade.entity.NoticiaDTO;
import com.anjade.entity.Imagen;
import com.anjade.repository.ImagenRepository;
import com.anjade.repository.NoticiaRepository;
import com.anjade.service.NoticiaService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticiaServiceImpl implements NoticiaService {

	@Autowired
    private NoticiaRepository noticiaRepository;
	
	@Autowired
    private ImagenRepository imagenRepository;
	
	@Value("${URL_SAVE_NOTICIA_IMAGEN}")
	private  String URL_SAVE_NOTICIA_IMAGEN;

	@Transactional
    public Noticia crearNoticia(NoticiaDTO noticiaDTO) {
        Noticia noticia = new Noticia();
        noticia.setTitulo(noticiaDTO.getTitulo());
        noticia.setLinkOriginal(noticiaDTO.getLinkOriginal());
        noticia.setTipo(noticiaDTO.getTipo());
        noticia.setFechaInsercion(LocalDateTime.now());

        for (String urlImagen : noticiaDTO.getImagenes()) {
            Imagen imagen = new Imagen();
            imagen.setUrlImagen(urlImagen);
         // Extrae el nombre de la imagen a partir de la URL
            String nombreImagen = extraerNombreImagen(urlImagen);
            imagen.setName(nombreImagen);  // Asigna el nombre de la imagen al campo 'name'
            imagen.setNoticia(noticia);
            noticia.getImagenes().add(imagen);
        }

        return noticiaRepository.save(noticia);
    }
	
	// Método auxiliar para extraer el nombre de la imagen desde la URL
	private String extraerNombreImagen(String urlImagen) {
	    if (urlImagen != null && urlImagen.contains("/")) {
	        // Obtiene el nombre completo después del último '/'
	        String nombreCompleto = urlImagen.substring(urlImagen.lastIndexOf('/') + 1);
	        
	        // Remueve la extensión del nombre de la imagen, si existe
	        int extensionIndex = nombreCompleto.lastIndexOf('.');
	        if (extensionIndex > 0) {
	            return nombreCompleto.substring(0, extensionIndex); // Nombre sin extensión
	        } else {
	            return nombreCompleto; // Retorna el nombre completo si no hay extensión
	        }
	    }
	    return null; // Retorna null si la URL es inválida
	}
	
	@Async
    public void limpiarContenidoTemporalAsync(Long noticiaId) {
        try {
            // Esperamos 30 segundos
            Thread.sleep(30000);
            
            // Limpiamos el contenido temporal
            Noticia noticia = noticiaRepository.findById(noticiaId).orElse(null);
            if (noticia != null) {
                for (Imagen imagen : noticia.getImagenes()) {
                    imagenRepository.save(imagen);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	public Page<Noticia> obtenerNoticias(int pagina, int tamanio, String tipo) {
	    PageRequest pageRequest = PageRequest.of(pagina, tamanio, Sort.by("fechaInsercion").descending());
	    if (tipo != null && !tipo.isEmpty()) {
	        return noticiaRepository.findByTipo(tipo, pageRequest);
	    } else {
	        return noticiaRepository.findAll(pageRequest);
	    }
	}
	
}
