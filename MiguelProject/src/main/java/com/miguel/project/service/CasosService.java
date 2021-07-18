package com.miguel.project.service;

import com.miguel.project.model.entity.CasosEntity;
import com.miguel.project.model.repository.CasosRepository;
import com.miguel.project.service.domain.CasosDomain;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CasosService {

    @Autowired
    private CasosRepository casosRepository;

    public List<CasosDomain> getCasos(){
        List<CasosEntity> casosEntities = new ArrayList<>();

        casosRepository.findAll().forEach(casosEntities::add);

        List<CasosDomain> casosDomainList = Mappers.getMapper(CasosMapper.class).entityToDomainList(casosEntities);

        return  casosDomainList;
    }

    public CasosDomain postCaso(CasosDomain casosDomain) throws Exception {
        CasosEntity casosEntity = Mappers.getMapper(CasosMapper.class).domainToEntity(casosDomain);

        casosEntity = casosRepository.save(casosEntity);

        Optional<CasosEntity> entityReturn = casosRepository.findById(casosEntity.getId());

        if (entityReturn.isPresent()){
            casosDomain = Mappers.getMapper(CasosMapper.class).entityToDomain(entityReturn.get());
        } else {
            throw new Exception("Erro into save entity");
        }

        return casosDomain;
    }
}
