package com.miguel.project.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miguel.project.model.entity.ClienteEntity;
import com.miguel.project.model.repository.ClienteRepository;
import com.miguel.project.service.domain.ClienteDomain;
import com.miguel.project.service.mapper.ClienteMapper;
import com.miguel.project.util.FileUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteService clienteService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testeGetClientes() throws IOException {
        String json = FileUtil.readFromFileToString("/jsonTemplate/cliente/clienteEntity.json");
        ClienteEntity clienteEntity = objectMapper.readValue(json, ClienteEntity.class);
        List<ClienteEntity> clienteEntityList = new ArrayList<>();
        clienteEntityList.add(clienteEntity);

        json = FileUtil.readFromFileToString("/jsonTemplate/cliente/clienteDomain.json");
        ClienteDomain clienteDomain = objectMapper.readValue(json, ClienteDomain.class);
        List<ClienteDomain> clienteDomainList = new ArrayList<>();
        clienteDomainList.add(clienteDomain);

        Mockito.when(clienteMapper.entityToDomainList(Mockito.anyList())).thenReturn(clienteDomainList);
        Mockito.when(clienteRepository.findAll()).thenReturn(clienteEntityList);

        List<ClienteDomain> retorno = clienteService.getClientes();

        Assert.assertNotNull(retorno);
    }
}
