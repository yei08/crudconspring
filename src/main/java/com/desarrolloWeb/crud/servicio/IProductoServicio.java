package com.desarrolloWeb.crud.servicio;

import java.util.List;
import com.desarrolloWeb.crud.modelo.Producto;


public interface IProductoServicio {
   
    public List<Producto> listarProductos();

    public void guardar (Producto product);

    public void eliminar (Producto product);

    public Producto buscar (Producto product);

    

    

}
