package com.banco.franco.servicebancousuario.service;

import com.banco.franco.servicebancousuario.dto.PersonDTO;
import org.springframework.http.ResponseEntity;

public interface DniService {
    ResponseEntity obtenerDatosPorDni(String dni);
}
