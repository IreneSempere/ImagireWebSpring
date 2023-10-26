package com.irene_sempere.hibernate.spring;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Promociones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	@Column(name = "FECHA_FIN")
	private Date fechaFin;
	private Boolean activa;
	private Float descuento;
	@Column(name = "PORCENTAJE_DESCUENTO")
	private Float porcentajeDescuento;
	@ManyToMany
	@JoinTable(name = "productos_promocionales", joinColumns = @JoinColumn(name = "ID_PROMOCION"), inverseJoinColumns = @JoinColumn(name = "ID_PRODUCTO"))
	private List<Productos> productos;

	
	
	public Promociones() {
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Boolean getActiva() {
		return activa;
	}

	public void setActiva(Boolean activa) {
		this.activa = activa;
	}

	public Float getDescuento() {
		return descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	public Float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Float porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Promociones [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", activa=" + activa + ", descuento=" + descuento
				+ ", porcentajeDescuento=" + porcentajeDescuento + "]";
	}

}
