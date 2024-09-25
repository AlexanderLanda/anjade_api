package com.anjade.entity;

public class CuestionarioRespuestaDto {
    private Long id;
    private Long userId;
    private String pregunta;
    private String nombreCampo;
    private String respuesta;
	
    
    
    public CuestionarioRespuestaDto() {
		super();
	}
	public CuestionarioRespuestaDto(Long id, Long userId, String pregunta, String nombreCampo, String respuesta) {
		super();
		this.id = id;
		this.userId = userId;
		this.pregunta = pregunta;
		this.nombreCampo = nombreCampo;
		this.respuesta = respuesta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getNombreCampo() {
		return nombreCampo;
	}
	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

 
    
    
    // Constructor, getters y setters
}