package com.anjade.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;


@Entity
@Table(name = "noticias")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String linkOriginal;
    private String tipo;
    private LocalDateTime fechaInsercion;
    private boolean isPropia;
    private String descripcion;

    @JsonManagedReference
    @OneToMany(mappedBy = "noticia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imagen> imagenes = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "noticia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentarioDto> comentarios = new ArrayList<>();

    
    // Getters y setters

	

	public Noticia() {
		super();
	}


	
	public Noticia(Long id, String titulo, String linkOriginal, String tipo, LocalDateTime fechaInsercion,
			boolean isPropia, String descripcion, List<Imagen> imagenes, List<ComentarioDto> comentarios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.linkOriginal = linkOriginal;
		this.tipo = tipo;
		this.fechaInsercion = fechaInsercion;
		this.isPropia = isPropia;
		this.descripcion = descripcion;
		this.imagenes = imagenes;
		this.comentarios = comentarios;
	}




	public boolean isPropia() {
		return isPropia;
	}



	public void setPropia(boolean isPropia) {
		this.isPropia = isPropia;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	

	public LocalDateTime getFechaInsercion() {
		return fechaInsercion;
	}

	public void setFechaInsercion(LocalDateTime fechaInsercion) {
		this.fechaInsercion = fechaInsercion;
	}


	public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public List<ComentarioDto> getComentarios() {
		return comentarios;
	}



	public void setComentarios(List<ComentarioDto> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	

}
