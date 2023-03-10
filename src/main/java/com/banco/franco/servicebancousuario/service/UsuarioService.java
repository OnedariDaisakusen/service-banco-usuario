package com.banco.franco.servicebancousuario.service;

import com.banco.franco.servicebancousuario.entitys.Usuario;

public interface UsuarioService {
    Usuario findById(Integer id);
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Usuario usuario);
    void deleteUsuario(Integer id);

}
