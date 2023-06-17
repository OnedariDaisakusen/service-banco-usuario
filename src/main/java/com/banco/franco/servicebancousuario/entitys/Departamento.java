package com.banco.franco.servicebancousuario.entitys;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_departamento")
@Data
public class Departamento {
    @Id
    @Column(name = "id_depa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "departamento")
    private String name;
}
