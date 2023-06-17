package com.banco.franco.servicebancousuario.service;

import com.banco.franco.servicebancousuario.dto.CuentaDTO;
import com.banco.franco.servicebancousuario.dto.CuentaUsuarioResponse;
import com.banco.franco.servicebancousuario.entitys.Usuario;
import com.banco.franco.servicebancousuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityExistsException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

/*    @Autowired
    CuentaClient cuentaClient;*/

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${URL_SERVICE_BANCO_CUENTA}")
    private String urlCuenta;

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

        usuario.setActiveUser("0");
        usuario.setUserDeleted("0");
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        Usuario resp = usuarioRepository.save(usuario);
        resp.setPassword("");
        return resp;
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

    @Override
/*
    @Transactional
*/
    public CuentaUsuarioResponse crearCuentaUsuario(Usuario usuario) {

        Optional<Usuario> findByDni = usuarioRepository.findByDocumentoIdentidad(usuario.getDocumentoIdentidad());

        Usuario usuarioBD = null;

        if(!findByDni.isPresent()){
            usuarioBD = createUsuario(usuario);
        }else{
            usuarioBD = findByDni.get();
        }

        CuentaDTO cuentaDTO = null;

        try {

            URI uri = new URI(urlCuenta + "/api/cuenta/crearCuentaPorUsuario");

            ResponseEntity<CuentaDTO> response = restTemplate.postForEntity(uri, usuarioBD, CuentaDTO.class);

            cuentaDTO = response.getBody();

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


        if(cuentaDTO == null){
            throw new NullPointerException("Error creando Cuenta");
        }

        CuentaUsuarioResponse resp = new CuentaUsuarioResponse();
        resp.setUsuario(usuarioBD);
        resp.setCuenta(cuentaDTO);

        return resp;
    }
}
