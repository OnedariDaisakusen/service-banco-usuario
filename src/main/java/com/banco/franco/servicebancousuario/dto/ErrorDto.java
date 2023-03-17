package com.banco.franco.servicebancousuario.dto;

import lombok.Data;

@Data
public class ErrorDto {
    private String message;
    private String status;

    public ErrorDto(String message, String status) {
        this.message = message;
        this.status = status;
    }
}
