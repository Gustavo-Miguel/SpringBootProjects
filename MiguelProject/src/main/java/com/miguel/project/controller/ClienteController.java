package com.miguel.project.controller;

import com.miguel.project.controller.request.ClienteRequest;
import com.miguel.project.service.ClienteService;
import com.miguel.project.service.domain.ClienteDomain;
import com.miguel.project.service.mapper.ClienteMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<List<ClienteDomain>> getClientes(){

        List<ClienteDomain> clienteDomainList = clienteService.getClientes();

        return new ResponseEntity<List<ClienteDomain>>(clienteDomainList, null, HttpStatus.OK);
    }

    @GetMapping(value = "/{nome}", produces = "application/json")
    public ResponseEntity<ClienteDomain> getCliente(@PathVariable String nome){

        ClienteDomain clienteDomain = clienteService.getCliente(nome);

        return new ResponseEntity<ClienteDomain>(clienteDomain, null, HttpStatus.OK);
    }

    @PostMapping(path = "/",produces = "application/json", consumes = "application/json")
    public ResponseEntity<ClienteDomain> postCliente(@RequestBody ClienteRequest clienteRequest) throws Exception {
        ClienteDomain clienteDomain = Mappers.getMapper(ClienteMapper.class).requestToDomain(clienteRequest);

        try {
            clienteDomain = clienteService.postCliente(clienteDomain);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity<ClienteDomain>(clienteDomain, null, HttpStatus.OK);
    }

}