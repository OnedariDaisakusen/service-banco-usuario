package com.banco.franco.servicebancousuario.repository;


import com.banco.franco.servicebancousuario.entitys.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProvinciaRepository extends JpaRepository<Provincia,String> {

    @Query(value = "select p from Provincia p where p.departamento = :idDepartamento", nativeQuery = false)
    List<Provincia> getProvinciaByDepartamento(@Param("idDepartamento") String idDepartamento);
}
