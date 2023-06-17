package com.banco.franco.servicebancousuario.service;


import com.banco.franco.servicebancousuario.entitys.Departamento;
import com.banco.franco.servicebancousuario.entitys.Distrito;
import com.banco.franco.servicebancousuario.entitys.Provincia;
import com.banco.franco.servicebancousuario.repository.DepartamentoRepository;
import com.banco.franco.servicebancousuario.repository.DistritoRepository;
import com.banco.franco.servicebancousuario.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbigeoServiceImpl implements UbigeoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    ProvinciaRepository provinciaRepository;

    @Autowired
    DistritoRepository distritoRepository;

    @Override
    public List<Departamento> getAllDepartamentos() {

        List<Departamento> resp = departamentoRepository.findAll();

        return resp;
    }

    @Override
    public List<Provincia> getProvinciaByDepartamento(String idDepartamento) {
        return provinciaRepository.getProvinciaByDepartamento(idDepartamento);
    }

    @Override
    public List<Distrito> getDistritoByProvincia(String idProvicnia) {
        return distritoRepository.getDistritoByProvicia(idProvicnia);
    }
}
