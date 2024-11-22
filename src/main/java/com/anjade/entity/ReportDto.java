package com.anjade.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private String referenciaReporte;
    @ManyToOne
    @JoinColumn(name = "deporte")
	private DeportesDto deporte;
    @ManyToOne
    @JoinColumn(name = "provincia")
	private ProvinciaDto provincia;
    
    @Column(name = "created_at")
    private Date createDate;


    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttachmentDto> attachments;
    
    

	public ReportDto() {
		super();
	}

	public ReportDto(Long id, String afiliacionId, String nombre, String apellidos, String descripcion, String telefono,
			String email, String referenciaReporte, DeportesDto deporte, ProvinciaDto provincia, Date createDate,
			List<AttachmentDto> attachments) {
		super();
		this.id = id;
		this.afiliacionId = afiliacionId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.email = email;
		this.referenciaReporte = referenciaReporte;
		this.deporte = deporte;
		this.provincia = provincia;
		this.createDate = createDate;
		this.attachments = attachments;
	}

	public DeportesDto getDeporte() {
		return deporte;
	}

	public void setDeporte(DeportesDto deporte) {
		this.deporte = deporte;
	}

	public ProvinciaDto getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaDto provincia) {
		this.provincia = provincia;
	}

	public String getReferenciaReporte() {
		return referenciaReporte;
	}

	public void setReferenciaReporte(String referenciaReporte) {
		this.referenciaReporte = referenciaReporte;
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