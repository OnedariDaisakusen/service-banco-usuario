package com.banco.franco.servicebancousuario.repository;


import com.banco.franco.servicebancousuario.entitys.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistritoRepository extends JpaRepository<Distrito, String> {

    @Query(value = "select d from Distrito d where d.provincia = :idProvincia", nativeQuery = false)
    List<Distrito> getDistritoByProvicia(@Param("idProvincia") String idProvincia);
}
