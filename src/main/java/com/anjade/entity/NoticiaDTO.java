package com.anjade.entity;

import java.util.List;

public class NoticiaDTO {
    private String titulo;
    private String linkOriginal;
    private String tipo;
    private List<String> imagenes;
    
    
    
    
	public NoticiaDTO(String titulo, String linkOriginal, String tipo, List<String> imagenes) {
		super();
		this.titulo = titulo;
		this.linkOriginal = linkOriginal;
		this.tipo = tipo;
		this.imagenes = imagenes;
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