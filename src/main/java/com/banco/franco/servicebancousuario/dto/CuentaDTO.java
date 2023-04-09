package com.banco.franco.servicebancousuario.dto;

import lombok.Data;

@Data
public class CuentaDTO {
    private Integer idCuenta;
    private Double saldo;
    private Integer idUsuario;
    private String estadoCuenta;
    private String numeroCuenta;

}
