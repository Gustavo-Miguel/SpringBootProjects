package com.miguel.project.controller;

import com.miguel.project.service.ClienteMapper;
import com.miguel.project.service.domain.ClienteDomain;
import com.miguel.project.service.ClienteService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(path = "/", produces = "application/json")
    public List<ClienteDomain> getClientes(){

        List<ClienteDomain> clienteDomainList = clienteService.getClientes();

        return clienteDomainList;
    }

    @GetMapping(value = "/{nome}", produces = "application/json")
    public ClienteDomain getCliente(@PathVariable String nome){

        ClienteDomain clienteDomain = clienteService.getCliente(nome);

        return clienteDomain;
    }

    @PostMapping(path = "/",produces = "application/json", consumes = "application/json")
    public  ClienteDomain postCliente(@RequestBody ClienteRequest clienteRequest) throws Exception {
        ClienteDomain clienteDomain = Mappers.getMapper(ClienteMapper.class).requestToDomain(clienteRequest);

        try {
            clienteDomain = clienteService.postCliente(clienteDomain);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return clienteDomain;
    }

}