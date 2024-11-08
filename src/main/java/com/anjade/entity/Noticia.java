package com.anjade.entity;

import java.time.LocalDateTime;
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

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String linkOriginal;

    @JsonManagedReference
    @OneToMany(mappedBy = "noticia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imagen> imagenes;

    @Column(nullable = false)
    private LocalDateTime fechaInsercion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoNoticia tipo;

    public enum TipoNoticia {
        PARTICULAR, GENERAL
    }

	

	public Noticia() {
		super();
	}

	public Noticia(Long id, String titulo, String linkOriginal, List<Imagen> imagenes, LocalDateTime fechaInsercion,
			TipoNoticia tipo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.linkOriginal = linkOriginal;
		this.imagenes = imagenes;
		this.fechaInsercion = fechaInsercion;
		this.tipo = tipo;
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

	public TipoNoticia getTipo() {
		return tipo;
	}

	public void setTipo(TipoNoticia tipo) {
		this.tipo = tipo;
	}

	public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}
	
	

}
