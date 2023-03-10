package com.banco.franco.servicebancousuario.service;

import com.banco.franco.servicebancousuario.entitys.Usuario;
import com.banco.franco.servicebancousuario.repository.UsuarioRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario findById(Integer id) {

        Optional<Usuario> response = usuarioRepository.findById(id);

        if(!response.isPresent()){
            throw new NullPointerException("Usuario no encontrado");
        }

        return response.get();
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {

        if(usuario == null){
            throw new NullPointerException("Cuerpo de solicitud nula");
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {

        if(usuario == null){
            throw new NullPointerException("Cuerpo de solicitud nula");
        }

        Usuario newUsuario = new Usuario();
        newUsuario.setId(usuario.getId());
        newUsuario.setNombreCompleto(usuario.getNombreCompleto());
        newUsuario.setNumeroTelefonico(usuario.getNumeroTelefonico());
        newUsuario.setDocumentoIdentidad(usuario.getDocumentoIdentidad());
        newUsuario.setActiveUser(usuario.getActiveUser());

        return usuarioRepository.save(newUsuario);
    }

    @Override
    public void deleteUsuario(Integer id) {

        if(id == null){
            throw new NullPointerException("Id Usuario Nulo");
        }

        try {
            usuarioRepository.deleteUser(id);
        }catch (Exception e){
            throw new EntityExistsException("No existe usuario");
        }

    }
}
