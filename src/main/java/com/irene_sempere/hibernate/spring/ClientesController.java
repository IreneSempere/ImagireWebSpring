package com.irene_sempere.hibernate.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientesController {
	
	
	// Inyectamos el DAO dentro del Controller
	@Autowired
	private ClientesDao clientesDao;
	
	@RequestMapping(value="/clientes/crear")
	@ResponseBody
	public String crear(String nombre, String email, String telefono) {
		try {
			Clientes cliente = new Clientes();
			cliente.setNombre(nombre);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			clientesDao.create(cliente);
		}catch(Exception e) {
			return "Error al crear el cliente: " + e.toString();
		}	
		return "Cliente creado correctamente";
	}
	
	@RequestMapping(value="/clientes/eliminar")
	@ResponseBody
	public String eliminar(int id) {
		try {
			Clientes cliente = new Clientes();
			cliente.setId(id);
			clientesDao.delete(cliente);
		} catch (Exception e) {
			return "Error al intentar eliminar el cliente: " + e.toString();
		}
		return "Cliente eliminado correctamente"; 
	}
	
	@RequestMapping(value="/clientes/actualizar")
	@ResponseBody
	public String actualizar(int id, String nombre, String email, String telefono) {
		try {
			Clientes cliente = clientesDao.getById(id);
			cliente.setNombre(nombre);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			clientesDao.update(cliente);
		}catch(Exception e) {
			return "Error al intentar actualizar el cliente: " + e.toString();
		}
		return "Cliente actualizado correctamente";
	}
	
	@RequestMapping(value="/clientes/buscar")
	@ResponseBody
	public String buscar(int id) {
		Clientes cliente = new Clientes();
		try {
			cliente = clientesDao.getById(id);
		}catch(Exception e) {
			return "Error al intentar obtener el cliente: " + e.toString();
		}
		return "Cliente obtenido: " + cliente.getNombre() + cliente.getPedidos();
	}
}
