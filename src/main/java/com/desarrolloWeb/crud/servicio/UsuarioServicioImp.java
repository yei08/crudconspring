package com.desarrolloWeb.crud.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desarrolloWeb.crud.IUsuarioCrud;
import com.desarrolloWeb.crud.modelo.Usuario;

@Service
public class UsuarioServicioImp implements IUsuarioServicio {

    @Autowired
    IUsuarioCrud crudUser;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) crudUser.findAll();
    }

    @Transactional
    @Override
    public void guardar(Usuario user) {
        crudUser.save(user);
    }

    @Transactional
    @Override
    public void eliminar(Usuario user) {
        crudUser.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario buscar(Usuario user) {
        return crudUser.findById(user.getId()).orElse(null);
    }

}
