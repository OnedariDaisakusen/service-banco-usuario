package com.banco.franco.servicebancousuario.repository;

import com.banco.franco.servicebancousuario.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "update Usuario u set userDeleted = '1' where id = :id")
    void deleteUser(@Param("id") Integer id);

}
