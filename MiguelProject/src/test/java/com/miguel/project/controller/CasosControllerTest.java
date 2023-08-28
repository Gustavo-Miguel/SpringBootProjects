package com.miguel.project.controller;

import com.miguel.project.controller.request.CasosRequest;
import com.miguel.project.service.CasosService;
import com.miguel.project.service.domain.CasosDomain;
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
public class CasosControllerTest {

    @Mock
    private CasosService casosService;

    @InjectMocks
    private CasosController casosController;

    @Test
    public void deveTestarGetController() throws Exception {
        CasosDomain casosDomain = new CasosDomain();
        List<CasosDomain> casosDomainList = new ArrayList<>();
        casosDomainList.add(casosDomain);

        Mockito.when(casosService.getCasos()).thenReturn(casosDomainList);

        ResponseEntity<List<CasosDomain>> retorno =  casosController.getCasos();
        Assert.assertEquals(retorno.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void deveTestarPostController() throws Exception {
        CasosDomain casosDomain = new CasosDomain();
        CasosRequest casosRequest = new CasosRequest();

        Mockito.when(casosService.postCaso(Mockito.any())).thenReturn(casosDomain);

        ResponseEntity<CasosDomain> retorno = casosController.postCaso(casosRequest);
        Assert.assertEquals(retorno.getStatusCode(), HttpStatus.OK);
    }
}
