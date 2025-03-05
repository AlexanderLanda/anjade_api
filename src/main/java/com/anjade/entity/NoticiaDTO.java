package com.anjade.entity;

import java.util.List;

public class NoticiaDTO {
    private String titulo;
    private String linkOriginal;
    private String tipo;
    private List<String> imagenes;
    private boolean isPropia;
    private String descripcion;

    
    
    
    
	public NoticiaDTO(String titulo, String linkOriginal, String tipo, List<String> imagenes, boolean isPropia,
			String descripcion) {
		super();
		this.titulo = titulo;
		this.linkOriginal = linkOriginal;
		this.tipo = tipo;
		this.imagenes = imagenes;
		this.isPropia = isPropia;
		this.descripcion = descripcion;
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