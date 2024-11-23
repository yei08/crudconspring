/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrolloWeb.crud.modelo;
import lombok.Data;
/**
 *
 * @author JEIFER ALCALA
 */
@Data
public class Usuario {
    private String id;
    private String password;
    private String nombre;
    private String apellidos;
    private String rol;
    private String email;
    private String telefono;
    private String estado;
    private String fecha_registro;
    
    
}
