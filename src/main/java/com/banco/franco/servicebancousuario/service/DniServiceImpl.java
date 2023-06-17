package com.banco.franco.servicebancousuario.service;

import com.banco.franco.servicebancousuario.dto.PersonDTO;
import com.banco.franco.servicebancousuario.dto.PersonaDTOV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DniServiceImpl implements DniService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity obtenerDatosPorDni(String dni) {

        String url = "https://api.apis.net.pe/v1/dni?numero=" + dni;
        String urlV2 = "https://dniruc.apisperu.com/api/v1/dni/" + dni +"?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImNvZGlnb2RvdGEyQGdtYWlsLmNvbSJ9.kSsGRRNC9nCTIZWaF3l5VF88neSl8d0YxMoCdYYRduc";

        //PersonDTO dto = restTemplate.getForObject(url, PersonDTO.class);

        try {
            ResponseEntity<PersonaDTOV2> entity = restTemplate.getForEntity(urlV2, PersonaDTOV2.class);
            return new ResponseEntity(entity.getBody(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error Desconocido", HttpStatus.NOT_FOUND);
        }


    }
}
