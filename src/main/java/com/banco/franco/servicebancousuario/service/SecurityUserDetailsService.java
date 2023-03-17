package com.banco.franco.servicebancousuario.service;

import com.banco.franco.servicebancousuario.entitys.Usuario;
import com.banco.franco.servicebancousuario.repository.UsuarioRepository;
import com.banco.franco.servicebancousuario.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public SecurityUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> user = this.usuarioRepository.findByDocumentoIdentidad(username);

        if(user.isPresent()){
            return new SecurityUser(user.get());
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }
}
