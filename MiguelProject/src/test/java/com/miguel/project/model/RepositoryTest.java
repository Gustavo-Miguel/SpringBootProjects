package com.miguel.project.model;

import com.miguel.project.model.entity.CasosEntity;
import com.miguel.project.model.entity.ClienteEntity;
import com.miguel.project.model.repository.CasosRepository;
import com.miguel.project.model.repository.ClienteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryTest {

    @Mock
    CasosRepository casosRepository;

    @Mock
    ClienteRepository clienteRepository;

    @Test
    public void testRepositoryCasos(){
        CasosEntity casosEntity = new CasosEntity();
        Mockito.when(casosRepository.findByNome(Mockito.any())).thenReturn(casosEntity);
        CasosEntity retorno = casosRepository.findByNome("teste");
        Assert.assertNotNull(retorno);
    }

    @Test
    public void testRepositoryClientes(){
        ClienteEntity clienteEntity = new ClienteEntity();
        Mockito.when(clienteRepository.findByNome(Mockito.any())).thenReturn(clienteEntity);
        ClienteEntity retorno = clienteRepository.findByNome("teste");
        Assert.assertNotNull(retorno);
    }
}
