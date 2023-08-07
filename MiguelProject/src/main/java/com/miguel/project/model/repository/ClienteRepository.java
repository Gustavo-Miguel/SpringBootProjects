package com.miguel.project.model.repository;

import com.miguel.project.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer> {

    ClienteEntity findByNome(@Param("nome") String nome);
}
