package com.banco.franco.servicebancousuario.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@Data
@NoArgsConstructor
public class Usuario {

    public Usuario(String nombreCompleto, String numeroTelefonico, String documentoIdentidad, String userDeleted, String activeUser, String password) {
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefonico = numeroTelefonico;
        this.documentoIdentidad = documentoIdentidad;
        this.userDeleted = userDeleted;
        this.activeUser = activeUser;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "numero_telefonico")
    private String numeroTelefonico;

    @Column(name = "documentoIdentidad")
    private String documentoIdentidad;

    @Column(name = "deleted_user")
    private String userDeleted;

    @Column(name = "active_user")
    private String activeUser;

    @Column(name = "password")
    private String password;

}
