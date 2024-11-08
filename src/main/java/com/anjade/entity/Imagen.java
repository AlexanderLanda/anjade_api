package com.anjade.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "imagenes")
public class Imagen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url_imagen")
    private String urlImagen; // Aquí guardamos la ruta o nombre del archivo

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "noticia_id")
    private Noticia noticia;

    /*
    @Lob
    @Column(name = "contenido_temporal")
    private byte[] contenidoTemporal;
    */
    
    
    
	public Imagen() {
		super();
	}


	public Imagen(Long id, String urlImagen, Noticia noticia) {
		super();
		this.id = id;
		this.urlImagen = urlImagen;
		this.noticia = noticia;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}





    
}