package com.banco.franco.servicebancousuario.entitys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_distrito")
@Data
public class Distrito {
    @Id
    @Column(name = "id_dist")
    private String id;
    @Column(name = "distrito")
    private String name;
    @Column(name = "id_prov")
    private String provincia;

}
