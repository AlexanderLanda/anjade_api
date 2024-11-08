package com.anjade.serviceImpl;

import com.anjade.entity.Noticia;
import com.anjade.entity.Imagen;
import com.anjade.repository.ImagenRepository;
import com.anjade.repository.NoticiaRepository;
import com.anjade.service.NoticiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	public Noticia crearNoticia(Noticia noticia, List<MultipartFile> imagenes) {
        noticia.setFechaInsercion(LocalDateTime.now());
        
        if (imagenes != null && !imagenes.isEmpty()) {
            List<Imagen> listaImagenes = new ArrayList<>();
            for (MultipartFile imagen : imagenes) {
                // Genera un nombre único para evitar colisiones
				String nombreArchivo = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
				// Define la ruta completa donde se almacenará la imagen
               
				/*
				String rutaArchivo = URL_SAVE_NOTICIA_IMAGEN + nombreArchivo; // Cambia esta ruta a tu carpeta local

				// Guarda la imagen en el sistema de archivos
				File archivo = new File(rutaArchivo);
				imagen.transferTo(archivo); // Guarda el archivo
				*/
				// Crea una nueva instancia de Imagen y guarda la URL

				Imagen img = new Imagen();
				img.setUrlImagen(URL_SAVE_NOTICIA_IMAGEN + nombreArchivo);
				//img.setContenidoTemporal(imagen.getBytes()); // Guardamos temporalmente el contenido
				img.setNoticia(noticia);
				listaImagenes.add(img);
            }
            noticia.setImagenes(listaImagenes);
        } else {
            noticia.setImagenes(new ArrayList<>());
        }
        
        Noticia noticiaGuardada = noticiaRepository.save(noticia);
        
        // Programamos la limpieza del contenido temporal
        limpiarContenidoTemporalAsync(noticiaGuardada.getId());
        
        return noticiaGuardada;
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
                    imagen.setContenidoTemporal(null);
                    imagenRepository.save(imagen);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Page<Noticia> obtenerNoticias(int pagina, int tamanio, Noticia.TipoNoticia tipo) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanio);
        if (tipo != null) {
            return noticiaRepository.findByTipoOrderByFechaInsercionDesc(tipo, pageRequest);
        } else {
            return noticiaRepository.findAllByOrderByFechaInsercionDesc(pageRequest);
        }
    }
	
}
