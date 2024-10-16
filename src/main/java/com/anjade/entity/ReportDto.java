package com.anjade.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reports")
public class ReportDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String afiliacionId;
    private String nombre;
    private String apellidos;
    private String descripcion;
    private String telefono;
    private String email;
    
    @Column(name = "created_at")
    private Date createDate;


    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttachmentDto> attachments;
    
    

	public ReportDto() {
		super();
	}

	public ReportDto(Long id, String afiliacionId, String nombre, String apellidos, String descripcion,
			List<AttachmentDto> attachments,Date createDate) {
		super();
		this.id = id;
		this.afiliacionId = afiliacionId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descripcion = descripcion;
		this.attachments = attachments;
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAfiliacionId() {
		return afiliacionId;
	}

	public void setAfiliacionId(String afiliacionId) {
		this.afiliacionId = afiliacionId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<AttachmentDto> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<AttachmentDto> attachments) {
		this.attachments = attachments;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String correo) {
		this.email = correo;
	}

	
    // Getters and Setters
}