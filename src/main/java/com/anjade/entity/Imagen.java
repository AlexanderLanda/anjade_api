package com.anjade.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlImagen;
    private String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "noticia_id")
    private Noticia noticia;
    
    
	public Imagen() {
		super();
	}


	public Imagen(Long id, String urlImagen,String name, Noticia noticia) {
		super();
		this.id = id;
		this.urlImagen = urlImagen;
		this.name = name;
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

	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}





    
}