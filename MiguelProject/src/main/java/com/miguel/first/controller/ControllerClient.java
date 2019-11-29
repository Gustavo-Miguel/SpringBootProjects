package com.miguel.first.controller;

import com.miguel.first.entity.ClienteEntity;
import com.miguel.first.domain.Cliente;
import com.miguel.first.repository.RepositoryCliente;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cliente")
public class ControllerClient {

    @Autowired
    private RepositoryCliente repositoryCliente;

    @GetMapping(path = "/", produces = "application/json")
    public Cliente getClientes(){

        ClienteEntity  clienteEntity = repositoryCliente.findcliente();

        Cliente cliente = Mappers.getMapper(ClienteMapper.class).toCliente(clienteEntity);

        return cliente;
    }
}
