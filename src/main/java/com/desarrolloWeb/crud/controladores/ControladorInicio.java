/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrolloWeb.crud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.desarrolloWeb.crud.modelo.Usuario;
import com.desarrolloWeb.crud.servicio.IUsuarioServicio;

import lombok.extern.slf4j.Slf4j;


/**
 *
 * @author JEIFER ALCALA
 */
@Controller
@Slf4j
public class ControladorInicio {
     @Autowired
     // IUsuarioCrud iUsuarioCrud;
     IUsuarioServicio userServicio;
    @GetMapping("/")
    public String inicio(Model modelo) {
        // List<Usuario> listaUsuarios = (List<Usuario>) iUsuarioCrud.findAll();
        List<Usuario> listaUsuarios = (List<Usuario>) userServicio.listarUsuarios();
        modelo.addAttribute("usuarios", listaUsuarios);
        log.info("ejecutando el controlador inicio MVC");
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Usuario usuario) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario) {
        userServicio.guardar(usuario);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Usuario usuario, Model modelo) {
        log.info("invocando el metodo editar");
        usuario = userServicio.buscar(usuario);
        modelo.addAttribute("usuario", usuario);
        return "modificar";
    }
}
