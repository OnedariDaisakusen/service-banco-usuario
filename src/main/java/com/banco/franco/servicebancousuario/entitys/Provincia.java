package com.banco.franco.servicebancousuario.entitys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_provincia")
@Data
public class Provincia {
    @Id
    @Column(name = "id_prov")
    private String id;
    @Column(name = "provincia")
    private String name;

    @Column(name = "id_depa")
    private String departamento;
}
