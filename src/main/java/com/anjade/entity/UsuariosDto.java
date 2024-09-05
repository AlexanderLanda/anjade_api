package com.anjade.entity;

import java.time.LocalDate;
import java.util.Date;
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
@Table(name = "usuarios")
public class UsuariosDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "fecha_nacimiento")
	private Date  fechaNacimiento;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "correo", unique = true, nullable = false)
	private String correo;
	
	@ManyToOne
    @JoinColumn(name = "deporte")
	private DeportesDto deporte;
	
	@ManyToOne
    @JoinColumn(name = "localidad")
	private LocalidadDto localidad;
	
	@Column(name = "documento")
	private String documento;
	
	@Column(name = "codigo_postal")
	private String codigoPostal;
	
	@ManyToOne
    @JoinColumn(name = "provincia")
	private ProvinciaDto provincia;
	
	@Column(name = "telefono", unique = true)
	private String telefono;
	
	@ManyToOne
    @JoinColumn(name = "afiliado_funcion")
	private AfiliadosFuncionDto afiliadosFuncion;
	
	@ManyToOne
    @JoinColumn(name = "afiliados_categoria")
	private AfiliadosCategoriasDto afiliadosCategoria;
	
	@ManyToOne
    @JoinColumn(name = "usuario_rol", nullable = true)
	private UsuariosRolDto usuariorol;
	
	@ManyToOne
    @JoinColumn(name = "estado_cuenta")
	private EstadosUsuariosDto estadoCuenta;
	
	@Column(name = "observaciones")
	private String observaciones;
	@Column(name = "password")
	private String password;
	
	@Column(name = "fecha_afiliacion")
	private  Date fechaAfiliacion;
	
	@Column(name = "federacion")
	private String federacion;
	
	@ManyToOne
    @JoinColumn(name = "tipo_pago")
	private TipoPagoDto tipoPago;
	
	@ManyToOne
    @JoinColumn(name = "tipo_documento")
	private TipoDocumentoDto tipoDocumento;
	
	@Column(name = "situacion_actual")
	private String situacionActual;
	
	@Column(name = "id_afiliacion")
	private String idAfiliacion;
	

	
	public UsuariosDto(Long id_user, String nombre, String apellidos, Date fechaNacimiento, String direccion,
			String correo, DeportesDto deporte, LocalidadDto localidad, String documento, String codigoPostal,
			ProvinciaDto provincia, String telefono, AfiliadosFuncionDto afiliadosFuncion,
			AfiliadosCategoriasDto afiliadosCategoria, UsuariosRolDto usuariorol, EstadosUsuariosDto estadoCuenta,
			String observaciones, String password, Date fechaAfiliacion, String federacion, TipoPagoDto tipoPago,
			TipoDocumentoDto tipoDocumento, String situacionActual,String idAfiliacion) {
		super();
		this.id_user = id_user;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.correo = correo;
		this.deporte = deporte;
		this.localidad = localidad;
		this.documento = documento;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.telefono = telefono;
		this.afiliadosFuncion = afiliadosFuncion;
		this.afiliadosCategoria = afiliadosCategoria;
		this.usuariorol = usuariorol;
		this.estadoCuenta = estadoCuenta;
		this.observaciones = observaciones;
		this.password = password;
		this.fechaAfiliacion = fechaAfiliacion;
		this.federacion = federacion;
		this.tipoPago = tipoPago;
		this.tipoDocumento = tipoDocumento;
		this.situacionActual = situacionActual;
		this.idAfiliacion = idAfiliacion;
	}



	public Long getId_user() {
		return id_user;
	}



	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	
	public String getIdAfiliacion() {
		return idAfiliacion;
	}



	public void setIdAfiliacion(String idAfiliacion) {
		this.idAfiliacion = idAfiliacion;
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



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public DeportesDto getDeporte() {
		return deporte;
	}



	public void setDeporte(DeportesDto deporte) {
		this.deporte = deporte;
	}



	public LocalidadDto getLocalidad() {
		return localidad;
	}



	public void setLocalidad(LocalidadDto localidad) {
		this.localidad = localidad;
	}



	public String getDocumento() {
		return documento;
	}



	public void setDocumento(String documento) {
		this.documento = documento;
	}



	public String getCodigoPostal() {
		return codigoPostal;
	}



	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}



	public ProvinciaDto getProvincia() {
		return provincia;
	}



	public void setProvincia(ProvinciaDto provincia) {
		this.provincia = provincia;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public AfiliadosFuncionDto getAfiliadosFuncion() {
		return afiliadosFuncion;
	}



	public void setAfiliadosFuncion(AfiliadosFuncionDto afiliadosFuncion) {
		this.afiliadosFuncion = afiliadosFuncion;
	}



	public AfiliadosCategoriasDto getAfiliadosCategoria() {
		return afiliadosCategoria;
	}



	public void setAfiliadosCategoria(AfiliadosCategoriasDto afiliadosCategoria) {
		this.afiliadosCategoria = afiliadosCategoria;
	}



	public UsuariosRolDto getUsuariorol() {
		return usuariorol;
	}



	public void setUsuariorol(UsuariosRolDto usuariorol) {
		this.usuariorol = usuariorol;
	}



	public EstadosUsuariosDto getEstadoCuenta() {
		return estadoCuenta;
	}



	public void setEstadoCuenta(EstadosUsuariosDto estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}



	public String getObservaciones() {
		return observaciones;
	}



	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Date getFechaAfiliacion() {
		return fechaAfiliacion;
	}



	public void setFechaAfiliacion(Date fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}



	public String getFederacion() {
		return federacion;
	}



	public void setFederacion(String federacion) {
		this.federacion = federacion;
	}



	public TipoPagoDto getTipoPago() {
		return tipoPago;
	}



	public void setTipoPago(TipoPagoDto tipoPago) {
		this.tipoPago = tipoPago;
	}



	public TipoDocumentoDto getTipoDocumento() {
		return tipoDocumento;
	}



	public void setTipoDocumento(TipoDocumentoDto tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}



	public String getSituacionActual() {
		return situacionActual;
	}



	public void setSituacionActual(String situacionActual) {
		this.situacionActual = situacionActual;
	}



	public UsuariosDto() {
		super();
	}



	public UsuariosDto orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
