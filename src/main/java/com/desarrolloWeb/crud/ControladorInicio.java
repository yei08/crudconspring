/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrolloWeb.crud;
import com.desarrolloWeb.crud.modelo.Usuario;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        u.setPassword("4234234");
        u.setNombre("yeifer");
        u.setApellidos("Alcalá Mestre");
        u.setRol("estudiante");
        u.setEmail("yalcalam@unicartagena.edu.com");
        u.setTelefono("4234252523");
        u.setEstado("activo");
        u.setFecha_registro("2020/03/30");
        modelo.addAttribute("alguien", u);
       
        Usuario u1 = new Usuario();
        u1.setId("1234");
        u1.setPassword("4234234");
        u1.setNombre("jonh jairo");
        u1.setApellidos("peñaralta rodriguez");
        u1.setRol("estudiante");
        u1.setEmail("john.com");
        u1.setTelefono("4234252523");
        u1.setEstado("activo");
        u1.setFecha_registro("2020/03/30");
      
        
        Usuario u2 = new Usuario();
        u2.setId("1236");
        u2.setPassword("4234234");
        u2.setNombre("johanis");
        u2.setApellidos("Mestre");
        u2.setRol("estudiante");
        u2.setEmail("johanis.com");
        u2.setTelefono("4234252523");
        u2.setEstado("activo");
        u2.setFecha_registro("2020/03/30");
        List<Usuario> listaUsuarios = Arrays.asList(u1, u2);
        modelo.addAttribute("usuarios",listaUsuarios);
        log.info("ejecutando el controlador inicio MVC");
        return "index";
    }
    
}
