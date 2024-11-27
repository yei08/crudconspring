package com.desarrolloWeb.crud.modelo;

import java.io.Serializable;

// import java.sql.Date;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "productos", catalog = "crudconspring")
@Data
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Float precio;
    private Integer cantidad;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_creacion;
    private Integer usuario_id;

}
