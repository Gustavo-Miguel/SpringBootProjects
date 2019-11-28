package com.miguel.first.repository;

import com.miguel.first.Entity.ClienteEntity;
import com.miguel.first.domain.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryCliente  extends CrudRepository<ClienteEntity, Integer> {


    @Query(value =  "SELECT u FROM ClienteEntity u WHERE u.id = 1", nativeQuery = true)
    ClienteEntity findId();
}
