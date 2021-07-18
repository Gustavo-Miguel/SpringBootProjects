package com.miguel.project.service;

import com.miguel.project.model.entity.CasosEntity;
import com.miguel.project.service.domain.CasosDomain;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CasosMapper {

    CasosDomain entityToDomain(CasosEntity casosEntity);

    List<CasosDomain> entityToDomainList(List<CasosEntity> casosEntities);

//    CasosDomain requestToDomain(ClienteRequest clienteRequest);

    CasosEntity domainToEntity(CasosDomain casosDomain);
}
