package com.anjade.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ayuda")
public class AyudaDto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pregunta;

    @Column(nullable = false)
    private String respuesta;

    @Column(nullable = false)
    private String modulo;

    public AyudaDto() {
		
	}
    
    public AyudaDto(Long id, String pregunta, String respuesta, String modulo) {
		super();
		this.id = id;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.modulo = modulo;
	}

	// Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
	
}
