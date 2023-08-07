package com.miguel.project.service;

import com.miguel.project.model.entity.ClienteEntity;
import com.miguel.project.model.repository.ClienteRepository;
import com.miguel.project.service.domain.ClienteDomain;
import com.miguel.project.service.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDomain> getClientes(){

        List<ClienteEntity> clienteEntities = new ArrayList<>();
        clienteRepository.findAll().forEach(clienteEntities::add);

        List<ClienteDomain> clienteDomainList = clienteMapper.entityToDomainList(clienteEntities);

        return clienteDomainList;
    }

    public ClienteDomain getCliente(String nome){

       ClienteEntity clienteEntity = clienteRepository.findByNome(nome);

        ClienteDomain clienteDomain = clienteMapper.entityToDomain(clienteEntity);

        return clienteDomain;
    }

    public ClienteDomain postCliente(ClienteDomain clienteDomain) throws Exception {
        ClienteEntity clienteEntity = clienteMapper.domainToEntity(clienteDomain);

        clienteEntity = clienteRepository.save(clienteEntity);

        Optional<ClienteEntity> entityReturn = clienteRepository.findById(clienteEntity.getId());

        if (entityReturn.isPresent()){
            clienteDomain = clienteMapper.entityToDomain(entityReturn.get());
        } else {
            throw new Exception("Erro into save entity");
        }

        return clienteDomain;
    }

}
