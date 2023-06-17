package com.banco.franco.servicebancousuario.util;

import com.banco.franco.servicebancousuario.entitys.Usuario;
import com.banco.franco.servicebancousuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    PasswordEncoder passwordEncoder;

    private final UsuarioRepository userRepository;

    public Runner(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
/*        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Franco Villanueva", "987654321", "70859665","0","0",passwordEncoder.encode("123456")));
        usuarios.add(new Usuario("Karen Gonzales", "985654212", "65985421","0","0",passwordEncoder.encode("123456")));
        userRepository.saveAll(usuarios);*/
    }
}
