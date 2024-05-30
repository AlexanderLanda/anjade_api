package com.anjade.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "localidad")
public class LocalidadDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_provincia")
	private ProvinciaDto idProvincia;


	public LocalidadDto() {
	}

	
	public LocalidadDto(Long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public ProvinciaDto getIdProvincia() {
		return idProvincia;
	}


	public void setIdProvincia(ProvinciaDto idProvincia) {
		this.idProvincia = idProvincia;
	}
	
	
	

}
