package com.miguel.first.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Cliente {

    public Cliente(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Cliente (){

    }

    @JsonProperty("id")
    public int id;

    @JsonProperty("nome")
    public String nome;

    @JsonProperty("idade")
    public int idade;
}
