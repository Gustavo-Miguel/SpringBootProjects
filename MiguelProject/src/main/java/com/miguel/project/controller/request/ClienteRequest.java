package com.miguel.project.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequest {

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("nome")
    public String nome;

    @JsonProperty("idade")
    public Integer idade;
}
