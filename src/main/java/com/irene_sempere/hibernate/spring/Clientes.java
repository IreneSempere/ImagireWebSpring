package com.irene_sempere.hibernate.spring;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Clientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String email;
	private String telefono;
	@OneToMany(mappedBy="cliente")
	private List<Pedidos> pedidos;
	
	
	public Clientes() {}


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public List<Pedidos> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	
}
