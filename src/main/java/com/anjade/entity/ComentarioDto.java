package com.anjade.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ComentarioDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "noticia_id", nullable = false)
    private Noticia noticia;

    private String texto;
    private String idAfiliacion;
    private LocalDateTime fechaComentario;
    private String nombre;
    
    
    
	public ComentarioDto() {
		super();
	}
	public ComentarioDto(Long id, Noticia noticia, String texto, String idAfiliacion, LocalDateTime fechaComentario, String nombre) {
		super();
		this.id = id;
		this.noticia = noticia;
		this.texto = texto;
		this.idAfiliacion = idAfiliacion;
		this.fechaComentario = fechaComentario;
		this.nombre = nombre;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Noticia getNoticia() {
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
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
	public LocalDateTime getFechaComentario() {
		return fechaComentario;
	}
	public void setFechaComentario(LocalDateTime fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

    
    
}
