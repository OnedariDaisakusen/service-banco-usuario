package com.banco.franco.servicebancousuario.controller;

import com.banco.franco.servicebancousuario.service.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ubigeo")
@CrossOrigin(origins = "*")
public class UbigeoController {

    @Autowired
    UbigeoService ubigeoService;

    @GetMapping("/getDepartamento")
    public ResponseEntity<?> getDepartamentos(){
        return new ResponseEntity<>(ubigeoService.getAllDepartamentos(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getProvincia/{idDepartamento}")
    public ResponseEntity<?> getDepartamentos(@PathVariable String idDepartamento){
        return new ResponseEntity<>(ubigeoService.getProvinciaByDepartamento(idDepartamento), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getDistrito/{idProvincia}")
    public ResponseEntity<?> getDistritos(@PathVariable String idProvincia){
        return new ResponseEntity<>(ubigeoService.getDistritoByProvincia(idProvincia), HttpStatus.ACCEPTED);
    }
}
