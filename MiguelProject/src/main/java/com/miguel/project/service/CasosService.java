package com.miguel.project.service;

import com.miguel.project.model.entity.CasosEntity;
import com.miguel.project.model.repository.CasosRepository;
import com.miguel.project.service.domain.CasosDomain;
import com.miguel.project.service.mapper.CasosMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CasosService {

    Logger logger = LogManager.getLogger(CasosService.class);

    @Autowired
    private CasosMapper casosMapper;
    @Autowired
    private CasosRepository casosRepository;

    public List<CasosDomain> getCasos(){
        List<CasosEntity> casosEntities = new ArrayList<>();

        casosRepository.findAll().forEach(casosEntities::add);

        List<CasosDomain> casosDomainList = casosMapper.entityToDomainList(casosEntities);

        return  casosDomainList;
    }

    public CasosDomain postCaso(CasosDomain casosDomain) throws Exception {

        CasosEntity casosEntity = casosMapper.domainToEntity(casosDomain);

        casosEntity = casosRepository.save(casosEntity);

        Optional<CasosEntity> entityReturn = casosRepository.findById(casosEntity.getId());

        if (entityReturn.isPresent()){
            casosDomain = casosMapper.entityToDomain(entityReturn.get());
        } else {
            throw new Exception("Erro into save entity");
        }

        return casosDomain;
    }
}
