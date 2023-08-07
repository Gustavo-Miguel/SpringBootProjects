package com.miguel.project.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CasosRequest {

    public Integer id;

    public String nome;

    public Integer idade;

    public String sexo;

    public String endereco;

    public String cidade;

    public String estado;

    public String email;

    public String telefone;

    public String doenca;

    public LocalDate dataContagio;

    public LocalDate dataRegistro;

    public Double latitude;

    public Double longitude;
}
