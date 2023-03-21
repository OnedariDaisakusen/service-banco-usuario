package com.banco.franco.servicebancousuario.clients;

import com.banco.franco.servicebancousuario.dto.CuentaDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface CuentaClient {
    @RequestMapping(method = RequestMethod.POST , value = "/posts")
    CuentaDTO crearCuenta(CuentaDTO cuenta);
}
