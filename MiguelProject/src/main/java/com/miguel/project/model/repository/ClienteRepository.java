package com.miguel.project.model.repository;

import com.miguel.project.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer> {

    @Query("select a from ClienteEntity a where a.nome = :nome")
    ClienteEntity findcliente(@Param("nome") String nome);
}
