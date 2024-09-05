package com.anjade.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cuestionario")
@Data
public class CuestionarioDto {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuestionario")
    private Long id;
    @Column(name = "pregunta")
    private String pregunta;
    
    @Column(name = "nombre_campo")
    private String nombreCampo;

    public CuestionarioDto() {
    }

    public CuestionarioDto(String pregunta, String nombreCampo) {
        this.pregunta = pregunta;
        this.nombreCampo = nombreCampo;
    }

    
    
    public String getNombreCampo() {
		return nombreCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

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
}