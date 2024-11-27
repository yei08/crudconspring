package com.desarrolloWeb.crud;
import com.desarrolloWeb.crud.modelo.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoCrud extends CrudRepository<Producto, Integer> {

}
