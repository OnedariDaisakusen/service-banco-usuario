package com.banco.franco.servicebancousuario.service;

import com.banco.franco.servicebancousuario.dto.PersonDTO;

public interface DniService {
    PersonDTO obtenerDatosPorDni(String dni);
}
