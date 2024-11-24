package com.desarrolloWeb.crud.servicio;

import java.util.List;
import com.desarrolloWeb.crud.modelo.Usuario;

public interface IUsuarioServicio {
    public List<Usuario> listarUsuarios();

    public void guardar (Usuario user);

    public void eliminar (Usuario user);

    public Usuario buscar (Usuario user);


}
