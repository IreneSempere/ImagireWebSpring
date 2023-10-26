package com.irene_sempere.hibernate.spring;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date fecha;
	@Column(name = "PRECIO_TOTAL")
	private Float precioTotal;
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE") // Nombre de la columna en la tabla de Pedidos que representa la relación
	private Clientes cliente;
	

	public Pedidos() {}

	
	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public Date getFecha() {
		return fecha;
	}





	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}





	public Float getPrecioTotal() {
		return precioTotal;
	}





	public void setPrecioTotal(Float precioTotal) {
		this.precioTotal = precioTotal;
	}





	public Clientes getCliente() {
		return cliente;
	}





	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}





	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", fecha=" + fecha + ", precioTotal=" + precioTotal + "]";
	}
	
	
}
