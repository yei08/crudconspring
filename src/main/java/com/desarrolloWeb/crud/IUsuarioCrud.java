package com.desarrolloWeb.crud;

import org.springframework.data.repository.CrudRepository;

import com.desarrolloWeb.crud.modelo.Usuario;

public interface IUsuarioCrud extends CrudRepository<Usuario, Integer> {


}
