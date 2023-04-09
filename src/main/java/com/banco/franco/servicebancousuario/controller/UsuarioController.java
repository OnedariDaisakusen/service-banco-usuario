package com.banco.franco.servicebancousuario.controller;

import com.banco.franco.servicebancousuario.entitys.Usuario;
import com.banco.franco.servicebancousuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(value = "*")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        return new ResponseEntity(usuarioService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/createUsuario")
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity(usuarioService.createUsuario(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/updateUsuario")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity(usuarioService.updateUsuario(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUsuario")
    public ResponseEntity<?> deleteUsuario(@RequestBody Integer id){
        return ResponseEntity.ok("dd");
    }

    @PostMapping("/crearCuentaUsuario")
    public ResponseEntity<?> crearCuentaUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity(usuarioService.crearCuentaUsuario(usuario), HttpStatus.CREATED);
    }
}
