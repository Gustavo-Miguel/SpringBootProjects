package com.miguel.project.service.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class CasosDomain {

    private Integer id;
    private String nome;
    private Integer idade;
    private String sexo;
    private String endereco;
    private String cidade;
    private String estado;
    private String email;
    private String telefone;
    private String doenca;
    private LocalDate dataContagio;
    private LocalDate dataRegistro;
    private Double latitude;
    private Double longitude;
}
