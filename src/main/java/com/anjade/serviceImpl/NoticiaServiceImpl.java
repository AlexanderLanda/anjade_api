package com.anjade.serviceImpl;

import com.anjade.entity.Noticia;
import com.anjade.entity.Imagen;
import com.anjade.repository.NoticiaRepository;
import com.anjade.service.NoticiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticiaServiceImpl implements NoticiaService {

	@Autowired
    private NoticiaRepository noticiaRepository;

    public Noticia crearNoticia(Noticia noticia, List<String> urlsImagenes) {
        noticia.setFechaInsercion(LocalDateTime.now());
        List<Imagen> imagenes = urlsImagenes.stream()
            .map(url -> {
                Imagen imagen = new Imagen();
                imagen.setUrlImagen(url);
                imagen.setNoticia(noticia);
                return imagen;
            })
            .collect(Collectors.toList());
        noticia.setImagenes(imagenes);
        return noticiaRepository.save(noticia);
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
