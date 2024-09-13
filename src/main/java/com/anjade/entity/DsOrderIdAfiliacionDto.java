package com.anjade.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "afiliados_dsorder")
public class DsOrderIdAfiliacionDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_afiliacion")
	private String idAfiliacion;
	
	@Column(name = "ds_order")
	private String dsOrder;

	@Column(name = "cod_response_redsys")
	private String codResponseRedsys;
	
	@Column(name = "fecha_de_pago")
	private Date fechaDePago;
	
	
	public DsOrderIdAfiliacionDto() {
		super();
	}



	public DsOrderIdAfiliacionDto( String idAfiliacion, String ds_order,String cod_response_redsys,Date fecha_de_pago) {
		super();
		this.idAfiliacion = idAfiliacion;
		this.dsOrder = ds_order;
		this.codResponseRedsys = cod_response_redsys;
		this.fechaDePago = fecha_de_pago;
	}



	public String getCod_response_redsys() {
		return codResponseRedsys;
	}



	public void setCod_response_redsys(String cod_response_redsys) {
		this.codResponseRedsys = cod_response_redsys;
	}



	public Date getFecha_de_pago() {
		return fechaDePago;
	}



	public void setFecha_de_pago(Date fecha_de_pago) {
		this.fechaDePago = fecha_de_pago;
	}



	public Long getId() {
		return id;
	}


	public String getIdAfiliacion() {
		return idAfiliacion;
	}



	public void setIdAfiliacion(String idAfiliacion) {
		this.idAfiliacion = idAfiliacion;
	}



	public String getDs_order() {
		return dsOrder;
	}



	public void setDs_order(String ds_order) {
		this.dsOrder = ds_order;
	}
	
	
	
}
