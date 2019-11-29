package com.miguel.first.controller;

import com.miguel.first.domain.Cliente;
import com.miguel.first.entity.ClienteEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper {

    Cliente toCliente(ClienteEntity clienteEntity);

}
