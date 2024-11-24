/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrolloWeb.crud.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.desarrolloWeb.crud.modelo.Usuario;
import com.desarrolloWeb.crud.IUsuarioCrud;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author JEIFER ALCALA
 */
@Controller
@Slf4j
public class ControladorInicio {
     @Autowired
      IUsuarioCrud iUsuarioCrud;
    @GetMapping("/")
    public String inicio(Model modelo) {
        List<Usuario> listaUsuarios = (List<Usuario>) iUsuarioCrud.findAll();
        modelo.addAttribute("usuarios", listaUsuarios);
        log.info("ejecutando el controlador inicio MVC");
        return "index";
    }

}
