package com.irene_sempere.hibernate.spring;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Productos {

	@Id
	@Column(name = "ID_PRODUCTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
//	@Column(name = "NOMBRE")
	private String nombre;
//	@Column(name = "DESCRIPCION")
	private String descripcion;
//	@Column(name = "STOCK")
	private Integer stock;
	@Column(name = "FECHA_LANZAMIENTO")
	private Date fechaLanzamiento;
//	@Column(name = "PRECIO")
	private Float precio;
	@Column(name = "PRECIO_OFERTA")
	private Float precioOferta;
	@Column(name = "TIPO_PRODUCTO")
	private String tipoProducto;
	@Column(name = "PATH_IMG")
	private String pathImg;
	@ManyToMany(mappedBy = "productos")
	private List<Promociones> promociones;
	

	public Productos() {}


	public Integer getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
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


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}


	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}


	public Float getPrecio() {
		return precio;
	}


	public void setPrecio(Float precio) {
		this.precio = precio;
	}


	public Float getPrecioOferta() {
		return precioOferta;
	}


	public void setPrecioOferta(Float precioOferta) {
		this.precioOferta = precioOferta;
	}


	public String getTipoProducto() {
		return tipoProducto;
	}


	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}


	public String getPathImg() {
		return pathImg;
	}


	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}


	public List<Promociones> getPromociones() {
		return promociones;
	}


	public void setPromociones(List<Promociones> promociones) {
		this.promociones = promociones;
	}

	
	
	
}
