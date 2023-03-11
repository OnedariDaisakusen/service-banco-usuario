package com.banco.franco.servicebancousuario.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tarjeta")
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero_tarjeta")
    private String numeroTarjeta;
    @Column(name = "fecha_expiracion")
    private String fechaExpiracion;
    @Column(name = "codigo_seguridad")
    private String codigoSeguridad;
    @Column(name = "marca_internacional")
    private String marcaInternacional;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario cliente;


}
