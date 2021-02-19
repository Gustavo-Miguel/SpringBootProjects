package com.miguel.project.service;

import com.miguel.project.model.entity.ClienteEntity;
import com.miguel.project.model.repository.ClienteRepository;
import com.miguel.project.service.domain.ClienteDomain;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDomain> getClientes(){

        List<ClienteEntity> clienteEntities = new ArrayList<>();
        clienteRepository.findAll().forEach(clienteEntities::add);

        List<ClienteDomain> clienteDomainList = Mappers.getMapper(ClienteMapper.class).entityToDomainList(clienteEntities);

        return clienteDomainList;
    }

    public ClienteDomain getCliente(String nome){

       ClienteEntity clienteEntity = clienteRepository.findByNome(nome);

        ClienteDomain clienteDomain = Mappers.getMapper(ClienteMapper.class).entityToDomain(clienteEntity);

        return clienteDomain;
    }

    public ClienteDomain postCliente(ClienteDomain clienteDomain) throws Exception {
        ClienteEntity clienteEntity = Mappers.getMapper(ClienteMapper.class).domainToEntity(clienteDomain);

        clienteEntity = clienteRepository.save(clienteEntity);

        Optional<ClienteEntity> entityReturn = clienteRepository.findById(clienteEntity.getId());

        if (entityReturn.isPresent()){
            clienteDomain = Mappers.getMapper(ClienteMapper.class).entityToDomain(entityReturn.get());
        } else {
            throw new Exception("Erro into save entity");
        }

        return clienteDomain;
    }

}
