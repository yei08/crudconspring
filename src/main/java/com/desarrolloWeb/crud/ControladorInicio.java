/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrolloWeb.crud;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.desarrolloWeb.crud.modelo.Usuario;
/**
 *
 * @author JEIFER ALCALA
 */
@Controller
@Slf4j
public class ControladorInicio {
    @Value("$(index.mensaje)")
    String dato;
    @GetMapping("/")
    public String inicio(Model modelo){
        String mensaje = "saludo desde spring mvc";
        modelo.addAttribute("mensaje", mensaje);
        modelo.addAttribute("dato", dato);
        Usuario u = new Usuario();
        u.setId("123");
        u.setPassword(dato);
        u.setNombre("yeifer");
        u.setApellidos("Alcalá Mestre");
        u.setRol("estudiante");
        u.setEmail("yalcalam@unicartagena.edu.com");
        u.setTelefono("4234252523");
        u.setEstado("activo");
        u.setFecha_registro("2020/03/30");
        modelo.addAttribute("alguien",u);
        
        log.info("ejecutando el controlador inicio MVC");
        return "index";
    }
    
}
