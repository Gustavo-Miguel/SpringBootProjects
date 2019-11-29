package com.miguel.first.repository;

import com.miguel.first.entity.ClienteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCliente  extends CrudRepository<ClienteEntity, Integer> {

    @Query("select a from ClienteEntity a where a.id = 1")
    ClienteEntity findcliente();
}
