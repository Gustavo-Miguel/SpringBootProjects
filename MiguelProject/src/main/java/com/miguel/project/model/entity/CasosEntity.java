package com.miguel.project.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="casos")
public class CasosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "doenca")
    private String doenca;

    @Column(name = "data_contagio")
    private LocalDate dataContagio;

    @Column(name = "data_registro")
    private LocalDate dataRegistro;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

}
