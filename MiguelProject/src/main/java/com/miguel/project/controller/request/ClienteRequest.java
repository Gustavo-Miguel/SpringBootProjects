package com.miguel.project.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequest {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("idade")
    private Integer idade;
}
