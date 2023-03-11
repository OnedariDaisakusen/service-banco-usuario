package com.banco.franco.servicebancousuario.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario {
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

    @OneToMany(mappedBy = "cliente")
    private List<Tarjeta> tarjetas;

}
