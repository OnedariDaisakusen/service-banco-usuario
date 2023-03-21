package com.banco.franco.servicebancousuario.dto;

import com.banco.franco.servicebancousuario.entitys.Usuario;
import lombok.Data;

@Data
public class CuentaUsuarioResponse {
    private Usuario usuario;
    private CuentaDTO cuenta;
}
