package com.irene_sempere.hibernate.spring;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IdCompuestoProductosPedido implements Serializable {
	
	@Column(name = "ID_PEDIDO")
	private int idPedido;
	@Column(name = "ID_PRODUCTO")
	private int idProducto;
	
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
//	@Override
//	public int hashCode() {
//		return super.hashCode();
//	}
//	@Override
//	public boolean equals(Object obj) {
//		return super.equals(obj);
//	}
}

