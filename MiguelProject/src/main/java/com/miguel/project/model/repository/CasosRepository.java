package com.miguel.project.model.repository;

import com.miguel.project.model.entity.CasosEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CasosRepository extends CrudRepository<CasosEntity, Integer> {

    @Query("select a from ClienteEntity a where a.nome = :nome")
    CasosEntity findByNome(@Param("nome") String nome);
}
