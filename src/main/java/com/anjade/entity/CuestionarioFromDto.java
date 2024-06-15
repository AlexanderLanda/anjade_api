package com.anjade.entity;

import java.util.List;

public class CuestionarioFromDto {
	private String nombreApellidos;
    private LocalidadDto localidad;
    private String telefono;
    private String correo;
    private String profesionLaboral;
    private String situacionActual;
    private int deporte;
    private String anosActivoCategorias;
    private String otrasActividades;
    private boolean colaborarAsociacion;
    private String tipoColaboracion;
    private String comisionColaboracion;
    private String idiomas;
    //private List<String> idiomas;
    private boolean tiempoLibre;
    private boolean desplazamiento;
    private boolean delegacionColaboracion;
    private String darClases;
    private boolean selectedDarClases;
    private boolean organizarEventosDeportivos;
    private boolean reunionesAsociacion;
    private boolean mediador;
    private boolean ayudaAgresiones;
    private String opinionAsociacion;
    private String mejorasAsociacion;
    private UsuariosDto usuarioDto;
    private String idAfiliacion;
    
    
    
    
    
	public CuestionarioFromDto() {
		super();
	}



	
	public String getIdAfiliacion() {
		return idAfiliacion;
	}




	public void setIdAfiliacion(String idAfiliacion) {
		this.idAfiliacion = idAfiliacion;
	}




	public String getNombreApellidos() {
		return nombreApellidos;
	}



	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}



	public LocalidadDto getLocalidad() {
		return localidad;
	}



	public void setLocalidad(LocalidadDto localidad) {
		this.localidad = localidad;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getProfesionLaboral() {
		return profesionLaboral;
	}



	public void setProfesionLaboral(String profesionLaboral) {
		this.profesionLaboral = profesionLaboral;
	}



	public String getSituacionActual() {
		return situacionActual;
	}



	public void setSituacionActual(String situacionActual) {
		this.situacionActual = situacionActual;
	}



	public int getDeporte() {
		return deporte;
	}



	public void setDeporte(int deporte) {
		this.deporte = deporte;
	}



	public String getAnosActivoCategorias() {
		return anosActivoCategorias;
	}



	public void setAnosActivoCategorias(String anosActivoCategorias) {
		this.anosActivoCategorias = anosActivoCategorias;
	}



	public String getOtrasActividades() {
		return otrasActividades;
	}



	public void setOtrasActividades(String otrasActividades) {
		this.otrasActividades = otrasActividades;
	}



	public boolean isColaborarAsociacion() {
		return colaborarAsociacion;
	}



	public void setColaborarAsociacion(boolean colaborarAsociacion) {
		this.colaborarAsociacion = colaborarAsociacion;
	}



	public String getTipoColaboracion() {
		return tipoColaboracion;
	}



	public void setTipoColaboracion(String tipoColaboracion) {
		this.tipoColaboracion = tipoColaboracion;
	}



	public String getComisionColaboracion() {
		return comisionColaboracion;
	}



	public void setComisionColaboracion(String comisionColaboracion) {
		this.comisionColaboracion = comisionColaboracion;
	}



	public  String getIdiomas() {
		return idiomas;
	}



	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}



	public boolean isTiempoLibre() {
		return tiempoLibre;
	}



	public void setTiempoLibre(boolean tiempoLibre) {
		this.tiempoLibre = tiempoLibre;
	}



	public boolean isDesplazamiento() {
		return desplazamiento;
	}



	public void setDesplazamiento(boolean desplazamiento) {
		this.desplazamiento = desplazamiento;
	}



	public boolean isDelegacionColaboracion() {
		return delegacionColaboracion;
	}



	public void setDelegacionColaboracion(boolean delegacionColaboracion) {
		this.delegacionColaboracion = delegacionColaboracion;
	}



	public String getDarClases() {
		return darClases;
	}



	public void setDarClases(String darClases) {
		this.darClases = darClases;
	}



	public boolean isSelectedDarClases() {
		return selectedDarClases;
	}



	public void setSelectedDarClases(boolean selectedDarClases) {
		this.selectedDarClases = selectedDarClases;
	}



	public boolean isOrganizarEventosDeportivos() {
		return organizarEventosDeportivos;
	}



	public void setOrganizarEventosDeportivos(boolean organizarEventosDeportivos) {
		this.organizarEventosDeportivos = organizarEventosDeportivos;
	}



	public boolean isReunionesAsociacion() {
		return reunionesAsociacion;
	}



	public void setReunionesAsociacion(boolean reunionesAsociacion) {
		this.reunionesAsociacion = reunionesAsociacion;
	}



	public boolean isMediador() {
		return mediador;
	}



	public void setMediador(boolean mediador) {
		this.mediador = mediador;
	}



	public boolean isAyudaAgresiones() {
		return ayudaAgresiones;
	}



	public void setAyudaAgresiones(boolean ayudaAgresiones) {
		this.ayudaAgresiones = ayudaAgresiones;
	}



	public String getOpinionAsociacion() {
		return opinionAsociacion;
	}



	public void setOpinionAsociacion(String opinionAsociacion) {
		this.opinionAsociacion = opinionAsociacion;
	}



	public String getMejorasAsociacion() {
		return mejorasAsociacion;
	}



	public void setMejorasAsociacion(String mejorasAsociacion) {
		this.mejorasAsociacion = mejorasAsociacion;
	}



	public UsuariosDto getUsuarioDto() {
		return usuarioDto;
	}



	public void setUsuarioDto(UsuariosDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}



	public CuestionarioFromDto(String nombreApellidos, LocalidadDto localidad, String telefono, String correo,
			String profesionLaboral, String situacionActual, int deporte, String anosActivoCategorias,
			String otrasActividades, boolean colaborarAsociacion, String tipoColaboracion, String comisionColaboracion,
			String idiomas, boolean tiempoLibre, boolean desplazamiento, boolean delegacionColaboracion,
			String darClases, boolean selectedDarClases, boolean organizarEventosDeportivos,
			boolean reunionesAsociacion, boolean mediador, boolean ayudaAgresiones, String opinionAsociacion,
			String mejorasAsociacion, UsuariosDto usuarioDto,String idAfiliacion) {
		super();
		this.nombreApellidos = nombreApellidos;
		this.localidad = localidad;
		this.telefono = telefono;
		this.correo = correo;
		this.profesionLaboral = profesionLaboral;
		this.situacionActual = situacionActual;
		this.deporte = deporte;
		this.anosActivoCategorias = anosActivoCategorias;
		this.otrasActividades = otrasActividades;
		this.colaborarAsociacion = colaborarAsociacion;
		this.tipoColaboracion = tipoColaboracion;
		this.comisionColaboracion = comisionColaboracion;
		this.idiomas = idiomas;
		this.tiempoLibre = tiempoLibre;
		this.desplazamiento = desplazamiento;
		this.delegacionColaboracion = delegacionColaboracion;
		this.darClases = darClases;
		this.selectedDarClases = selectedDarClases;
		this.organizarEventosDeportivos = organizarEventosDeportivos;
		this.reunionesAsociacion = reunionesAsociacion;
		this.mediador = mediador;
		this.ayudaAgresiones = ayudaAgresiones;
		this.opinionAsociacion = opinionAsociacion;
		this.mejorasAsociacion = mejorasAsociacion;
		this.usuarioDto = usuarioDto;
		this.idAfiliacion = idAfiliacion;
	}
    
    

}
