package com.miguel.first.controller;

import com.miguel.first.Entity.ClienteEntity;
import com.miguel.first.domain.Cliente;
import com.miguel.first.repository.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/cliente")
public class ControllerClient {

    @Autowired
    private RepositoryCliente repositoryCliente;

    @GetMapping(path = "/", produces = "application/json")
    public Cliente getClientes(){

        ClienteEntity  clienteEntity = repositoryCliente.findId();

        Cliente cliente = new Cliente();

        cliente.id = clienteEntity.getId();
        cliente.nome = clienteEntity.getNome();
        cliente.idade = clienteEntity.getIdade();

        return cliente;
    }
}
