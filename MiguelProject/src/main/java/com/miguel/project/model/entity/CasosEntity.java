package com.miguel.project.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="casos")
public class CasosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "nome")
    public String nome;

    @Column(name = "idade")
    public Integer idade;

    @Column(name = "sexo")
    public String sexo;

    @Column(name = "endereco")
    public String endereco;

    @Column(name = "cidade")
    public String cidade;

    @Column(name = "estado")
    public String estado;

    @Column(name = "email")
    public String email;

    @Column(name = "telefone")
    public String telefone;

    @Column(name = "doenca")
    public String doenca;

    @Column(name = "data_contagio")
    public LocalDate dataContagio;

    @Column(name = "data_registro")
    public LocalDate dataRegistro;

    @Column(name = "latitude")
    public Double latitude;

    @Column(name = "longitude")
    public Double longitude;


    public Integer getId() {
        return id;
    }
}
