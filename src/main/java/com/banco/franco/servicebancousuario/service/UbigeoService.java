package com.banco.franco.servicebancousuario.service;



import com.banco.franco.servicebancousuario.entitys.Departamento;
import com.banco.franco.servicebancousuario.entitys.Distrito;
import com.banco.franco.servicebancousuario.entitys.Provincia;

import java.util.List;

public interface UbigeoService {
    List<Departamento> getAllDepartamentos();
    List<Provincia> getProvinciaByDepartamento(String idDepartamento);
    List<Distrito> getDistritoByProvincia(String idProvicnia);
}
