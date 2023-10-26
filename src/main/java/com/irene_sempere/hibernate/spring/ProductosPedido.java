package com.irene_sempere.hibernate.spring;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProductosPedido {
	
	@EmbeddedId
	private IdCompuestoProductosPedido idCompuesto;
	@Column(name = "PRECIO_PRODUCTO")
	private float precioProducto;
	@Column(name = "CANTIDAD_PRODUCTO")
	private int cantidadProducto;
	
	
	
	public ProductosPedido() {}

	

	public IdCompuestoProductosPedido getIdCompuesto() {
		return idCompuesto;
	}

	public void setIdCompuesto(IdCompuestoProductosPedido idCompuesto) {
		this.idCompuesto = idCompuesto;
	}

	public float getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(float precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
}
