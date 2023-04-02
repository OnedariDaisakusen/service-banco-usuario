package com.banco.franco.servicebancousuario.controller;

import com.banco.franco.servicebancousuario.service.DniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dni")
public class DniController {

    @Autowired
    DniService dniService;

    @GetMapping("/{dni}")
    public ResponseEntity<?> obtenerDni(@PathVariable(name = "dni") String dni){
        return ResponseEntity.ok(dniService.obtenerDatosPorDni(dni));
    }
}
