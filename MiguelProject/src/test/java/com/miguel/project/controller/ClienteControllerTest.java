package com.miguel.project.controller;

import com.miguel.project.controller.request.ClienteRequest;
import com.miguel.project.service.ClienteService;
import com.miguel.project.service.domain.ClienteDomain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    public void deveTestarGetClientesController() throws Exception {
        ClienteDomain clienteDomain = new ClienteDomain();
        List<ClienteDomain> clienteDomainList = new ArrayList<>();
        clienteDomainList.add(clienteDomain);

        Mockito.when(clienteService.getClientes()).thenReturn(clienteDomainList);

        ResponseEntity<List<ClienteDomain>> retorno =  clienteController.getClientes();
        Assert.assertEquals(retorno.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void deveTestarGetClienteController() throws Exception {
        ClienteDomain clienteDomain = new ClienteDomain();
        String nome = "teste";

        Mockito.when(clienteService.getCliente(Mockito.any())).thenReturn(clienteDomain);

        ResponseEntity<ClienteDomain> retorno =  clienteController.getCliente(nome);
        Assert.assertEquals(retorno.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void deveTestarPostClienteController() throws Exception {
        ClienteDomain clienteDomain = new ClienteDomain();
        ClienteRequest clienteRequest = new ClienteRequest();

        Mockito.when(clienteService.postCliente(Mockito.any())).thenReturn(clienteDomain);

        ResponseEntity<ClienteDomain> retorno =  clienteController.postCliente(clienteRequest);
        Assert.assertEquals(retorno.getStatusCode(), HttpStatus.OK);
    }
}
