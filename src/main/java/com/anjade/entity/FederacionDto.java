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
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "federacion")
public class FederacionDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_deporte")
	private DeportesDto idDeporte;

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

	public DeportesDto getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(DeportesDto idDeporte) {
		this.idDeporte = idDeporte;
	}

	public FederacionDto(Long id, String descripcion, DeportesDto idDeporte) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.idDeporte = idDeporte;
	}

	public FederacionDto() {
		super();
	}
	
	
}
