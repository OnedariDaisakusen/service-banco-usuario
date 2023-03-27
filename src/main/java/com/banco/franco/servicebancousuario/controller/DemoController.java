package com.banco.franco.servicebancousuario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class DemoController {

    @GetMapping("/demo")
    public String demo(){
        return "Demo endpoint";
    }
}
