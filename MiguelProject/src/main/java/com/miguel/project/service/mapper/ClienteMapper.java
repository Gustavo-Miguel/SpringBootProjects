package com.miguel.project.service.mapper;

import com.miguel.project.controller.request.ClienteRequest;
import com.miguel.project.service.domain.ClienteDomain;
import com.miguel.project.model.entity.ClienteEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteDomain entityToDomain(ClienteEntity clienteEntity);

    List<ClienteDomain> entityToDomainList(List<ClienteEntity> clienteEntities);

    ClienteDomain requestToDomain(ClienteRequest clienteRequest);

    ClienteEntity domainToEntity(ClienteDomain clienteDomain);

}
