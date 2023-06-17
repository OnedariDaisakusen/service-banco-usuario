package com.banco.franco.servicebancousuario.dto;

import lombok.Data;

@Data
public class PersonaDTOV2 {
    private String success;
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Integer codVerifica;
    private String message;

}
