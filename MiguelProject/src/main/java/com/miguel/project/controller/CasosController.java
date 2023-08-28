package com.miguel.project.controller;

import com.miguel.project.controller.request.CasosRequest;
import com.miguel.project.service.mapper.CasosMapper;
import com.miguel.project.service.CasosService;
import com.miguel.project.service.domain.CasosDomain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/casos")
public class CasosController {

    Logger logger = LogManager.getLogger(CasosController.class);

    @Autowired
    private CasosService casosService;

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<List<CasosDomain>> getCasos(){

        List<CasosDomain> casosDomainList = casosService.getCasos();

        return new ResponseEntity<List<CasosDomain>>(casosDomainList, null, HttpStatus.OK);
    }

    @PostMapping(path = "/",produces = "application/json", consumes = "application/json")
    public ResponseEntity<CasosDomain> postCaso(@RequestBody CasosRequest casosRequest) throws Exception {

        CasosDomain casosDomain = Mappers.getMapper(CasosMapper.class).requestToDomain(casosRequest);

        try {
            casosDomain = casosService.postCaso(casosDomain);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity<CasosDomain>(casosDomain, null, HttpStatus.OK);
    }
}
