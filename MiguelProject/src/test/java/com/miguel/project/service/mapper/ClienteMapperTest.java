package com.miguel.project.service.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miguel.project.controller.request.ClienteRequest;
import com.miguel.project.model.entity.ClienteEntity;
import com.miguel.project.service.domain.ClienteDomain;
import com.miguel.project.util.FileUtil;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ClienteMapperTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testeMapperRequestToDomain() throws IOException {
        String json = FileUtil.readFromFileToString("/jsonTemplate/cliente/clienteRequest.json");
        ClienteRequest clienteRequest = objectMapper.readValue(json, ClienteRequest.class);

        ClienteDomain clienteDomain = Mappers.getMapper(ClienteMapper.class).requestToDomain(clienteRequest);

        Assert.assertNotNull(clienteDomain);
        Assertions.assertThat(clienteDomain).isEqualToComparingFieldByField(clienteRequest);
    }

    @Test
    public void testeMapperDomainToEntity() throws IOException {
        String json = FileUtil.readFromFileToString("/jsonTemplate/cliente/clienteDomain.json");
        ClienteDomain clienteDomain = objectMapper.readValue(json, ClienteDomain.class);

        ClienteEntity clienteEntity = Mappers.getMapper(ClienteMapper.class).domainToEntity(clienteDomain);

        Assert.assertNotNull(clienteEntity);
        Assertions.assertThat(clienteEntity).isEqualToComparingFieldByField(clienteDomain);
    }

    @Test
    public void testeMapperEntityToDomain() throws IOException {
        String json = FileUtil.readFromFileToString("/jsonTemplate/cliente/clienteEntity.json");
        ClienteEntity clienteEntity = objectMapper.readValue(json, ClienteEntity.class);

        ClienteDomain clienteDomain = Mappers.getMapper(ClienteMapper.class).entityToDomain(clienteEntity);

        Assert.assertNotNull(clienteDomain);
        Assertions.assertThat(clienteDomain).isEqualToComparingFieldByField(clienteEntity);
    }

    @Test
    public void testeMapperEntityListToDomainList() throws IOException {
        String json = FileUtil.readFromFileToString("/jsonTemplate/cliente/clienteEntity.json");
        ClienteEntity clienteEntity = objectMapper.readValue(json, ClienteEntity.class);
        List<ClienteEntity> clienteEntityList = new ArrayList<>();
        clienteEntityList.add(clienteEntity);

        List<ClienteDomain> clienteDomainList = Mappers.getMapper(ClienteMapper.class).entityToDomainList(clienteEntityList);

        Assert.assertNotNull(clienteDomainList);
        Assertions.assertThat(clienteDomainList.stream().findFirst().get()).isEqualToComparingFieldByField(clienteEntityList.stream().findFirst().get());
    }
}
