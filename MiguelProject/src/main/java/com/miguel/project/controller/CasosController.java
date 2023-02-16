package com.miguel.project.controller;

import com.miguel.project.service.CasosMapper;
import com.miguel.project.service.CasosService;
import com.miguel.project.service.domain.CasosDomain;
import com.miguel.project.util.MapperLog;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/casos")
public class CasosController {

    Logger logger = LogManager.getLogger(CasosController.class);

    @Autowired
    private CasosService casosService;

    @GetMapping(path = "/", produces = "application/json")
    public List<CasosDomain> getCasos(){

        List<CasosDomain> casosDomainList = casosService.getCasos();

        return casosDomainList;
    }

    @PostMapping(path = "/",produces = "application/json", consumes = "application/json")
    public  CasosDomain postCliente(@RequestBody CasosRequest casosRequest) throws Exception {

        logger.info("Teste splunk 1", MapperLog.mapToJsonString(casosRequest));

        CasosDomain casosDomain = Mappers.getMapper(CasosMapper.class).requestToDomain(casosRequest);

        try {
            casosDomain = casosService.postCaso(casosDomain);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return casosDomain;
    }
}
