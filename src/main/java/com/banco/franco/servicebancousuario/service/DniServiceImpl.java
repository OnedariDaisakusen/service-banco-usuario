package com.banco.franco.servicebancousuario.service;

import com.banco.franco.servicebancousuario.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DniServiceImpl implements DniService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public PersonDTO obtenerDatosPorDni(String dni) {

        String url = "https://api.apis.net.pe/v1/dni?numero=" + dni;

        try {
            PersonDTO dto = restTemplate.getForObject(url, PersonDTO.class);
            return dto;

        }catch (NullPointerException e){
            throw new NullPointerException("Persona no encontrada");
        }
    }
}
