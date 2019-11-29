package com.miguel.first.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="clientes")
@Getter @Setter
public class ClienteEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int id;

    @Column(name = "nome")
    public String nome;

    @Column(name = "idade")
    public int idade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
