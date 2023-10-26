package com.irene_sempere.hibernate.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductosController {
	
	
	// Inyectamos el DAO dentro del Controller
	@Autowired
	private ProductosDao productosDao;
	
	@RequestMapping(value="/productos/crear")
	@ResponseBody
	public String crear(String nombre, float precio, int stock) {
		try {
			Productos producto = new Productos();
			producto.setNombre(nombre);
			producto.setPrecio(precio);
			producto.setStock(stock);
			productosDao.create(producto);
		}catch(Exception e) {
			return "Error al crear el producto: " + e.toString();
		}	
		return "Producto creado correctamente";
	}
	
	@RequestMapping(value="/productos/eliminar")
	@ResponseBody
	public String eliminar(int id) {
		try {
			Productos producto = new Productos();
			producto.setIdProducto(id);
			productosDao.delete(producto);
		} catch (Exception e) {
			return "Error al intentar eliminar el producto: " + e.toString();
		}
		return "Producto eliminado correctamente"; 
	}
	
	@RequestMapping(value="/productos/actualizar")
	@ResponseBody
	public String actualizar(int id, String nombre, float precio, int stock) {
		try {
			Productos producto = productosDao.getById(id);
			producto.setNombre(nombre);
			producto.setPrecio(precio);
			producto.setStock(stock);
			productosDao.update(producto);
		}catch(Exception e) {
			return "Error al intentar actualizar el producto: " + e.toString();
		}
		return "Producto actualizado correctamente";
	}
	
	@RequestMapping(value="/productos/buscar")
	@ResponseBody
	public String buscar(int id) {
		Productos producto = new Productos();
		try {
			producto = productosDao.getById(id);
		}catch(Exception e) {
			return "Error al intentar obtener el cliente: " + e.toString();
		}
		return "Producto obtenido: " + producto.getNombre() + " " +producto.getPromociones();
	}
	
	@GetMapping("/productos")
	public String mostrar(Model model) {
		List<Productos> listaProductos = new ArrayList<Productos>();
		try {
			listaProductos = productosDao.getAll();
			model.addAttribute("listaProductos", listaProductos);
		}catch(Exception e) {
			return "Error al intentar obtener los productos: " + e.toString();
		}
		return "productos";
	}
	
	@GetMapping("/ejemplo")
    public String mostrarPagina(Model model) {
        model.addAttribute("mensaje", "Hola, mundo!");
        return "mi_pagina";
    }
}
