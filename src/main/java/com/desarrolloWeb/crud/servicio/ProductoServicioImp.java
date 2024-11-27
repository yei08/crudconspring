package com.desarrolloWeb.crud.servicio;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.desarrolloWeb.crud.IProductoCrud;
import com.desarrolloWeb.crud.modelo.Producto;

@Service
public class ProductoServicioImp implements IProductoServicio {

    @Autowired
    IProductoCrud productoCrud;

    @Transactional(readOnly = true)
    @Override
    public List<Producto> listarProductos() {
        return (List<Producto>) productoCrud.findAll();
    }

    @Transactional
    @Override
    public void guardar(Producto producto) {
        productoCrud.save(producto);
    }

    @Transactional
    @Override
    public void eliminar(Producto producto) {
        productoCrud.delete(producto);
    }
    
    @Transactional(readOnly = true)
    @Override
    public Producto buscar(Producto producto) {
        return productoCrud.findById(producto.getId()).orElse(null);
    }
}