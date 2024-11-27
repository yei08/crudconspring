package com.desarrolloWeb.crud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.desarrolloWeb.crud.modelo.Producto;
import com.desarrolloWeb.crud.servicio.IProductoServicio;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorProducto {

    @Autowired
    IProductoServicio productoServicio;

    @GetMapping("/productos")
    public String inicio(Model modelo) {
        List<Producto> listaProductos = (List<Producto>) productoServicio.listarProductos();
        modelo.addAttribute("Productos", listaProductos);
        log.info("ejecutando el controlador de productos");
        return "productos";
    }

    @GetMapping("/productos/agregar")
    public String agregar(Producto producto) {
        return "modificarProducto";
    }

    @PostMapping("/productos/guardar")
    public String guardar(Producto producto) {
        productoServicio.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String editar(@PathVariable("id") Producto id, Model modelo) { // Cambiado a int
        log.info("invocando el metodo editar producto");
        Producto producto = productoServicio.buscar(id); // Buscar producto por ID
        modelo.addAttribute("producto", producto);
        return "modificarProducto";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminar(Producto producto) {
        productoServicio.eliminar(producto);
        return "redirect:/productos";
    }
}